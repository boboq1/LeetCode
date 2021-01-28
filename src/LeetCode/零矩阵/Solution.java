package LeetCode.零矩阵;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<int[]> zeroIndex = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    int[]index = {i,j};
                    zeroIndex.add(index);
                }
            }
        }
        for (int[] index : zeroIndex) {
            int R = index[0];
            int C = index[1];
            for (int i = 0; i < row; i++) {
                matrix[i][C] = 0;
            }
            for (int i = 0; i < col; i++) {
                matrix[R][i] = 0;
            }
        }
    }
}
