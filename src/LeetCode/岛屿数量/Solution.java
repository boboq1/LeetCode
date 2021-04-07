package LeetCode.岛屿数量;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

//    深度优先遍历
    /*public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0 || grid == null) return 0;
        int L = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < L; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid,i,j);
                }

            }
        }
        return count;
    }
    private void dfs(char[][] grid,int i,int j) {
        int n = grid.length;
        int l = grid[0].length;
        if (i < n && i >= 0 && j < l && j >= 0 && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid,i - 1,j);
            dfs(grid,i,j - 1);
            dfs(grid,i + 1,j);
            dfs(grid,i,j + 1);
        }
    }*/
    //广度优先遍历
public int numIslands(char[][] grid) {
    int n = grid.length;
    if (n == 0 || grid == null) return 0;
    int L = grid[0].length;
    int num_island = 0;
    Queue<Integer> gridQueue = new LinkedList<>();
    for (int rc = 0; rc < n; rc++) {
        for (int rl = 0; rl < L; rl++) {
            if (grid[rc][rl] == '1') {
                grid[rc][rl] = '0';
                num_island++;
                int num = rc * L + rl;
                gridQueue.add(num);
                while (!gridQueue.isEmpty()) {
                    for (int i = 0; i < gridQueue.size(); i++) {
                        int top = gridQueue.remove();
                        int c = top / L;
                        int l = top % L;
                        if (c - 1 >=0 && grid[c - 1][l] == '1') {
                            grid[c - 1][l] = '0';
                            gridQueue.add((c - 1) * L + l);
                        }
                        if (c + 1 < n && grid[c + 1][l] == '1') {
                             gridQueue.add((c + 1) * L + l);
                             grid[c + 1][l] = '0';
                        }
                        if (l - 1 >= 0 && grid[c][l - 1] == '1') {
                            gridQueue.add(c * L + l - 1);
                            grid[c][l - 1] = '0';
                        }
                        if (l + 1 < L && grid[c][l + 1] == '1') {
                            gridQueue.add(c * L + l + 1);
                            grid[c][l + 1] = '0';
                        }
                    }
                }
            }
        }
    }
    return num_island;
}
    //并查集
   /* class UnionFind {
        int count;
        int[] parent;
        int[] rank;
        public UnionFind(char[][] grid) {
            int rc = grid.length;
            int rl = grid[0].length;
            count = 0;
            parent = new int[rc * rl];
            rank = new int[rc * rl];
            for (int c = 0; c < rc; c++) {
                for (int l = 0; l < rl; l++) {
                    if (grid[c][l] == '1') {
                        parent[c * rl + l] = c * rl + l;
                        count++;
                    }
                }
            }
        }
        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x,int y){
            int rc = find(x);
            int rl = find(y);
            *//*如果得到的两个根节点不等，则说明这两个集合未合并，下面合并这两个集合*//*
            if (rc != rl){
                parent[rl] = rc;
                count--;
                }
        }
        public int getCount(){
            return count;
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0 || grid == null) return 0;
        int L = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < L; j++) {
                if (grid[i][j] == '1') {
                   grid[i][j] = '0';
                   if (i - 1 >=0 && grid[i - 1][j] == '1'){
                       uf.union(i * L + j, (i - 1) * L + j);
                   }
                   if (i + 1 < n && grid[i + 1][j] == '1') {
                       uf.union(i * L + j, (i + 1) * L + j);
                   }
                   if (j - 1 >=0 && grid[i][j - 1] == '1') {
                       uf.union(i * L + j, i * L + (j - 1));
                   }
                   if (j + 1 < L && grid[i][j + 1] == '1') {
                       uf.union(i * L + j, i * L + (j + 1));
                   }
                }

            }
        }
        return uf.getCount();
    }*/
}
