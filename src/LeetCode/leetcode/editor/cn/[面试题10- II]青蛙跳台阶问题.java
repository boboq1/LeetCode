//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 递归

package LeetCode.leetcode.editor.cn;

class QingWaTiaoTaiJieWenTiLcof {
    public static void main(String[] args) {
        Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*public int numWays(int n) {

            int[] nums = new int[n + 1];
            return helper(n, nums);
        }

        private int helper(int n, int[] nums) {
            if (n == 0) return 1;
            if (n == 1) return 1;
            if (n == 2) return 2;
            nums[0] = 0;
            nums[1] = 1;
            nums[2] = 2;
            if (nums[n] > 0) return nums[n];
            nums[n] = (helper(n-1,nums) + helper(n-2,nums))%1000000007;
            return nums[n];
        }*/
        public int numWays(int n) {
            int temp = 0;
            int a = 1,b = 1;
            for (int i = 0; i < n; i++) {
                 temp = (a+b)%1000000007;
                 a = b;
                 b = temp;
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}