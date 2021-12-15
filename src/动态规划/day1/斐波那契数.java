package 动态规划.day1;

/**
 * @Auther: 13771
 * @Date: 2021/12/12 16:52
 * @Description: Solution
 * @Version 1.0.0
 */
public class 斐波那契数 {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        if (n < 2) return n;
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
