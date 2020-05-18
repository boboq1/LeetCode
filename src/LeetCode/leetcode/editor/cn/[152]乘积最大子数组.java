//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 *
// Related Topics 数组 动态规划

package LeetCode.leetcode.editor.cn;

class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*public int maxProduct(int[] nums) {
            int len = nums.length;
            if (len == 0) return 0;
            int ans = 0;
            int[][]dp = new int[len][2];
            dp[0][0] = nums[0];
            dp[0][1] = nums[0];
            for (int i = 1; i < len; i++) {
                if (nums[i] >=0) {
                    dp[i][0] = Math.min(nums[i],nums[i]*dp[i-1][0]);
                    dp[i][1] = Math.max(nums[i],nums[i]*dp[i-1][1]);
                }else {
                    dp[i][0] = Math.min(nums[i],nums[i]*dp[i-1][1]);
                    dp[i][1] = Math.max(nums[i],nums[i]*dp[i-1][0]);
                }
            }
            ans = dp[0][1];
            for (int[] ints : dp) {
                ans = Math.max(ans,ints[1]);
            }
            return ans;
        }*/
        public int maxProduct(int[] nums) {
            int len = nums.length;
            if (len == 0) return 0;
            int preMin = nums[0];
            int preMax = nums[0];
            int curMin = 0,curMax =0;
            int ans = nums[0];
            for (int i = 1; i < len; i++) {
                if (nums[i] >= 0){
                    curMin = Math.min(nums[i],preMin*nums[i]);
                    curMax = Math.max(nums[i],preMax*nums[i]);
                }else {
                    curMin = Math.min(nums[i],preMax*nums[i]);
                    curMax = Math.max(nums[i],preMin*nums[i]);
                }
                preMin = curMin;
                preMax = curMax;
                ans = Math.max(ans,curMax);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}