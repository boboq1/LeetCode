package LeetCode.旋转矩阵;

public class Solution {
    /*   public void rotate(int[][] matrix) {
           int length = matrix.length;
           int[][] copyMatrix = new int[length][length];
           for (int i = 0; i < length; i++) {
               for (int j = 0; j < length; j++) {
                   copyMatrix[j][length - 1 - i] = matrix[i][j];
               }
           }
           for (int i = 0; i < length; i++) {
               for (int j = 0; j < length; j++) {
                   matrix[i][j] = copyMatrix[i][j];
               }
           }
       }*/
  /*  public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < (length + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - j][i];
                matrix[length - 1 - j][i] = matrix[length - 1 - i][length - 1 - j];
                matrix[length - 1 - i][length - 1 - j] = matrix[j][length - 1 - i];
                matrix[j][length - 1 - i] = temp;
            }
        }
    }*/
    public void rotate(int[][] matrix) {
       int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - i][j];
                matrix[length - 1 - i][j] = temp;
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
