package LeetCode.队列.岛屿数量;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: hcb
 * @Date: 2021/2/17 14:18
 * @Version 1.0
 */
public class Solution {
    //bfs
    /* public int numIslands(char[][] grid) {
         int res = 0;
         int nr = grid.length;
         int nc = grid[0].length;
         for (int r = 0; r < nr; r++) {
             for (int c = 0; c < nc; c++) {
                 if (grid[r][c] == '1') {
                     res++;
                     Queue<Integer> queue = new LinkedList<>();
                     queue.offer(r * nc + c);
                     while (!queue.isEmpty()) {
                         int id = queue.poll();
                         int row = id / nc;
                         int col = id % nc;
                         if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                             queue.offer((row - 1) * nc + col);
                             grid[row - 1][col] = '0';
                         }
                         if (row + 1 < nr && grid[row + 1][col] == '1') {
                             queue.offer((row + 1) * nc + col);
                             grid[row + 1][col] = '0';
                         }
                         if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                             queue.offer(row * nc + col - 1);
                             grid[row][col - 1] = '0';
                         }
                         if (col + 1 < nc && grid[row][col + 1] == '1') {
                             queue.offer(row * nc + col + 1);
                             grid[row][col + 1] = '0';
                         }
                     }
                 }
             }
         }
         return res;
     }*/
    //dfs
    /*public int numIslands(char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int count = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || r >= nr || c < 0 || c >= nc || grid[r][c] == '0') return;
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }*/
    //并查集


}
