//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划

package LeetCode.leetcode.editor.cn;
   class MaximalSquare{
      public static void main(String[] args) {
           Solution solution = new MaximalSquare().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0){
                    dp[i][j] = matrix[i][j]-'0';
                }else {
                    if (matrix[i][j] - '0' == 1){
                        dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+ 1;
                    }else {
                        dp[i][j] = 0;
                    }
                }
                ans = Math.max(ans,dp[i][j]);
            }
        }
        ans = ans * ans;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }