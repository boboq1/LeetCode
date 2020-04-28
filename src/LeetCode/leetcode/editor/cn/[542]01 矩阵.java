package LeetCode.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
//
// 两个相邻元素间的距离为 1 。 
//
// 示例 1: 
//输入: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 示例 2: 
//输入: 
//
// 
//0 0 0
//0 1 0
//1 1 1
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//1 2 1
// 
//
// 注意: 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 深度优先搜索 广度优先搜索


class Zero1Matrix {
    public static void main(String[] args) {
        Solution solution = new Zero1Matrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //BFS 将0放入队列 或 将1放入队列
 /*   public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<> ();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 1){
                    queue.offer(new int[]{i,j});
                }else {
                    matrix[i][j]=-1;
                }
            }
        }
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        int[]point = new int[2];
        while (!queue.isEmpty()){
            point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < 4; ++i) {
                int X = x+dx[i];
                int Y = y+dy[i];
                if (X>=0&&X<m&&Y>=0&&Y<n&&matrix[X][Y]==-1){
                    matrix[X][Y]= matrix[x][y]+1;
                    queue.offer(new int[]{X,Y});
                }
            }
        }
        return matrix;
    }*/
        /*public int[][] updateMatrix(int[][] matrix) {
            //设置x和ycoordinate的四个方向
            int[]dx= {-1,1,0,0};
            int[]dy = {0,0,-1,1};
            int m = matrix.length;
            int n = matrix[0].length;
            //设置一个与matrix大小相同的数组
            int[][] res = new int[m][n];
            //放置1的队列
            Queue<int[]> queue = new LinkedList < int[] > ();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j]==0){
                        for (int t = 0; t < 4; t++) {
                            int cx = i + dx[t];
                            int cy = j + dy[t];
                            if (cx>=0&&cx<m&&cy>=0&&cy<n&&matrix[cx][cy]==1&&res[cx][cy]==0){
                                queue.offer(new int[]{cx,cy});
                                res[cx][cy]=1;
                            }
                        }
                    }
                }
            }
            while (!queue.isEmpty()){
                int[]point = queue.poll();
                int x = point[0];
                int y = point[1];
                for (int i = 0; i < 4; i++) {
                    int cx = x + dx[i];
                    int cy = y + dy[i];
                    if (cx>=0&&cx<m&&cy>=0&&cy<n&&matrix[cx][cy]==1&&res[cx][cy]==0){
                        res[cx][cy] = res[x][y] + 1;
                        queue.offer(new int[]{cx,cy});
                    }
                }
            }
            return res;

        }*/
        //动态规划
        /*public int[][] updateMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            //设置数组存放距离
            int[][]dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = matrix[i][j]==0?0:10000;
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i-1>=0){
                        dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+1);
                    }
                    if (j-1>=0){
                        dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+1);
                    }
                }
            }
            for (int i = m-1; i >= 0; i--) {
                for (int j = n-1; j >= 0; j--) {
                    if (i+1<m){
                        dp[i][j] = Math.min(dp[i+1][j]+1,dp[i][j]);
                    }
                    if (j+1<n){
                        dp[i][j] = Math.min(dp[i][j],dp[i][j+1]+1);
                    }
                }
            }
            return dp;
        }*/
        public int[][] updateMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] res = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res[i][j] = matrix[i][j] == 0 ? 0 : 10000;
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i - 1 >= 0) {
                        res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
                    }
                }
            }
            for (int i = m-1; i >= 0; i--) {
                for (int j = n-1; j >= 0; j--) {
                    if (i + 1 < m) {
                        res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
                    }
                    if (j + 1 < n) {
                        res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}