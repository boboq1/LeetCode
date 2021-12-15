package 动态规划.day1;

/**
 * @Auther: 13771
 * @Date: 2021/12/12 17:00
 * @Description: N个泰波那契数
 * @Version 1.0.0
 */
public class N个泰波那契数 {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n < 3) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
