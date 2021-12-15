package 动态规划.day3;

/**
 * @Auther: 13771
 * @Date: 2021/12/13 16:16
 * @Description: 打家劫舍II
 * @Version 1.0.0
 */
public class 打家劫舍II {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int[] nums1 = new int[n - 1];
        int[] nums2 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            nums1[i] = nums[i];
        }
        for (int i = 1; i < n; i++) {
            nums2[i - 1] = nums[i];
        }
        return Math.max(robRange(nums1), robRange(nums2));
    }

    public int robRange(int[] numsi) {
        int n = numsi.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = numsi[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + numsi[i - 1]);
        }
        return dp[n];
    }
}
