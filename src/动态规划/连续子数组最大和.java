package 动态规划;

/**
 * @Auther: 13771
 * @Date: 2021/11/15 15:09
 * @Description: 连续子数组最大和
 * @Version 1.0.0
 */
public class 连续子数组最大和 {
    public static void main(String[] args) {
        new 连续子数组最大和().maxSubArray(new int[]{-2, -1});
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            if (i == 1) result = dp[1];
            result = Math.max(result, dp[i]);
        }
        /*int last = 0;
        int temp = 0;
        for (int i = 1; i <= n; i++) {
            temp = Math.max(last + nums[i - 1], nums[i - 1]);
            if (i == 1) result = temp;
            result = Math.max(result, temp);
            last = temp;
        }*/
        return result;
    }
}
