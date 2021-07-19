package LeetCode.h0318岛屿数量;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //dfs
    /*public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0 || grid == null) return 0;
        int l = grid[0].length;
        int num_islnad = 0;
        for (int rc = 0; rc < n; rc++) {
            for (int rl = 0; rl < l; rl++) {
                if (grid[rc][rl] == '1') {
                    num_islnad++;
                    dfs(grid,rc,rl);
                }
            }
        }
        return num_islnad;
    }

    private void dfs(char[][] grid, int c, int l) {
        int n = grid.length;
        int L = grid[0].length;
        if (grid[c][l] == '1'){
            grid[c][l] = '0';
            if (c + 1 < n) dfs(grid,c + 1,l);
            if (l + 1 < L) dfs(grid,c,l + 1);
            if (c - 1 >= 0) dfs(grid,c - 1,l);
            if (l - 1 >= 0) dfs(grid,c,l - 1);
        }
    }*/
    //bfs
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0 || grid == null) return 0;
        int l = grid[0].length;
        int num_islnad = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int rc = 0; rc < n; rc++) {
            for (int rl = 0; rl < l; rl++) {
                if (grid[rc][rl] == '1'){
                    num_islnad++;
                    grid[rc][rl] = '0';
                    queue.add(rc * l + rl);
                }
                while (!queue.isEmpty()) {
                    for (int i = 0; i < queue.size(); i++) {
                        int id = queue.remove();
                        int x = id / l;
                        int y = id % l;
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = '0';
                            queue.add((x - 1) * l + y);
                        }
                        if (x + 1 < n && grid[x + 1][y] == '1') {
                            grid[x + 1][y] = '0';
                            queue.add((x + 1) * l + y);
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = '0';
                            queue.add(x * l + y - 1);
                        }
                        if (y + 1 < l && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = '0';
                            queue.add(x  * l + y + 1);
                        }
                    }
                }
            }
        }
        return num_islnad;
    }

}
