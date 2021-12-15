package 动态规划.day4;

/**
 * @Auther: 13771
 * @Date: 2021/12/15 21:28
 * @Description: 跳跃游戏II
 * @Version 1.0.0
 */
public class 跳跃游戏II {
    public int jump(int[] nums) {
        int n = nums.length;
        int steps = 0;
        int end = 0;
        int maxLen = 0;
        for (int i = 0; i < n - 1; i++) {
            maxLen = Math.max(maxLen, i + nums[i]);
            if (i == end) {
                end = maxLen;
                steps++;
            }
        }
        return steps;
    }
}
