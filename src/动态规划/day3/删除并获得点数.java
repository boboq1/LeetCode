package 动态规划.day3;

/**
 * @Auther: 13771
 * @Date: 2021/12/13 17:05
 * @Description: 删除并获得点数
 * @Version 1.0.0
 */
public class 删除并获得点数 {
    /*
     * 题意是删除选中的一个num[i]相邻的num[i] - 1和num[i] + 1*/
    public int deleteAndEarn(int[] nums) {
        int maxValue = 0;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        int[] sum = new int[maxValue + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        return rob(sum);
    }

    public int rob(int[] nums) {
        int length = nums.length;
        int first = nums[0];
        int second = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
