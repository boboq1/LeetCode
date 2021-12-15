package 动态规划.day2;

/**
 * @Auther: 13771
 * @Date: 2021/12/13 11:20
 * @Description: 使用最小花费爬楼梯
 * @Version 1.0.0
 */
public class 使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev = 0, curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
