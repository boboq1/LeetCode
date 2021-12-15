package 动态规划.day3;

/**
 * @Auther: 13771
 * @Date: 2021/12/13 15:48
 * @Description: 打家劫舍
 * @Version 1.0.0
 */
public class 打家劫舍 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[n];
    }
}
