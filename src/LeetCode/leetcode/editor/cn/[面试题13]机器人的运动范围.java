//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 1： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
//

package LeetCode.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //dfs
        private int m,n,k;
        private boolean[][]visited;
        public int movingCount(int m, int n, int k) {
            this.m = m;
            this.n = n;
            this.k = k;
            boolean[][] visited = new boolean[m][n];
            this.visited = visited;
            return dfs(0,0,0,0);
        }
        private int dfs(int i,int j,int si,int sj) {
            if (i>=m||j>=n||si+sj>k||visited[i][j])return 0;
            visited[i][j]=true;
            return 1+dfs(i+1,j,(i+1)%10==0?si-8:si+1,sj)+dfs(i,j+1,si,(j+1)%10==0?sj-8:sj+1);
        }

        //bfs
       /* public int movingCount(int m, int n, int k) {
            int res = 0;
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{0, 0, 0, 0});
            boolean[][] visited = new boolean[m][n];
            while (queue.size() > 0) {
                int[] temp = queue.poll();
                int i = temp[0], j = temp[1], si = temp[2], sj = temp[3];
                if (i >= m || j >= n || si + sj > k || visited[i][j]) continue;
                visited[i][j] = true;
                res++;
                queue.add(new int[]{i + 1, j, (i + 1) % 10 == 0 ? si - 8 : si + 1, sj});
                queue.add(new int[]{i, j + 1, si, (j + 1) % 10 == 0 ? sj - 8 : sj + 1});

            }
            return res;
        }*/

    }
//leetcode submit region end(Prohibit modification and deletion)

}