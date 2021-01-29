package LeetCode.对角线遍历;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: hcb
 * @Date: 2021/1/28 10:11
 * @Version 1.0
 */
public class Solution {
   /* public int[] findDiagonalOrder(int[][] matrix) {
        //排除特殊情况
        if (matrix == null || matrix.length == 0) return new int[0];
        int row = matrix.length;
        int col = matrix[0].length;
        int[] result = new int[row * col];
        int count = 0;
        ArrayList<Integer> intermedaite = new ArrayList<>();
        for (int d = 0; d < row + col - 1; d++) {
            intermedaite.clear();
            int r = d < col ? 0 : d - col + 1;
            int c = d < col ? d : col - 1;
            while (r < row && c > -1) {
                intermedaite.add(matrix[r][c]);
                ++r;
                c--;
            }
            if (d % 2 == 0) {
                Collections.reverse(intermedaite);
            }
            for (int i = 0; i < intermedaite.size() ; i++) {
                result[count++] = intermedaite.get(i);
            }
        }
        return result;
    }*/
   public int[] findDiagonalOrder(int[][] matrix) {
       if (matrix == null || matrix.length == 0 || matrix[0].length == 0 ) return new int[0];

       int row = matrix.length;
       int col = matrix[0].length;
       int[] nums = new int[row*col];
       int k = 0;
       boolean flag = true;
       for (int i = 0; i < row + col; i++) {
           int m = flag ? row : col;
           int n = flag ? col : row;
           int x = (i < m) ? i : m - 1;
           int y = i - x;
           while (x >=0 && y < n) {
               nums[k++] = flag?matrix[x][y]:matrix[y][x];
               x--;
               y++;
           }
           flag = !flag;
       }
       return nums;
   }
}
