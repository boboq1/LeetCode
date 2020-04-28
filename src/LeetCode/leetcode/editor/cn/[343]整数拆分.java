//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。 
//
// 示例 1: 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。 
// Related Topics 数学 动态规划

package LeetCode.leetcode.editor.cn;

class IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new IntegerBreak().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //方法一数学
        public int integerBreak(int n) {
            if (n <= 3) return n - 1;
            int a = n / 3;
            int b = n % 3;
            if (b == 0) return (int) Math.pow(3, a);
            if (b == 1) return (int) Math.pow(3, a - 1) * 4;
            return (int) (Math.pow(3, a) * 2);

        }

        /*public int integerBreak(int n) {
            if (n <= 1) return 0;
            if (n ==2) return 1;
            if (n ==3 ) return 2;
            int left = n / 2;
            int right = n - left;
            return helper(n, left, right);
        }

        private int helper(int n, int left, int right) {
            if (left*right<n) return n;
            return helper(left,left/2,left-left /2)*helper(right,right /2,right - right /2);
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}