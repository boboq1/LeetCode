package LeetCode.矩阵中的幸运数;
import	java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/3/15 10:36
 */
public class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] maxNum = new int[matrix.length];
        int[] minNum = new int[matrix[0].length];
        int min = Integer.MAX_VALUE;
        int max = 0;
        List<Integer> list = new ArrayList<Integer> ();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0;j < matrix[i].length;j++) {
                maxNum[i] = Math.max(maxNum[i],matrix[i][j]);
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0;j < matrix.length;j++) {
                minNum[i] = Math.min(minNum[i],matrix[i][j]);
            }
        }
        Arrays.sort(minNum);
        Arrays.sort(maxNum);
        int len = Math.min(minNum.length,maxNum.length);
        for (int i = 0; i < len; i++) {
            if (minNum[i]==maxNum[i])
                list.add(minNum[i]);
        }
        return list;
    }
}
