package 动态规划.day4;

/**
 * @Auther: 13771
 * @Date: 2021/12/15 20:32
 * @Description: 跳跃游戏
 * @Version 1.0.0
 */
public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
