package LeetCode.H494目标和;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: hechenbo
 * @Description: target
 * @DateTime: 2021/7/19 12:04
 **/
public class Solution {
    /*思路：target减去或加上nums数组中元素，最后的结果==0则方法数+1
     * */
    //方法一：回溯法（深度优先便利）
   /* int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backTrack(nums, target, 0, 0);
        return count;
    }

    private void backTrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;

            }
        } else {
            backTrack(nums, target, index + 1, sum + nums[index]);
            backTrack(nums, target, index + 1, sum - nums[index]);
        }
    }*/
    //方法二：dp
    public int findTargetSumWays(int[] nums, int target) {
        //sum是nums里元素和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int reg = diff / 2;
        int n = nums.length;
        int[][] dp = new int[n + 1][reg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= reg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][reg];
    }
}