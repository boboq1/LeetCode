package LeetCode.统计有序矩阵中的负数;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/2/16 10:37
 */
public class Solution {
    public int countNegatives(int[][] grid) {
        int sum=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]<0)sum++;
            }
        }
        return sum;
    }
}
