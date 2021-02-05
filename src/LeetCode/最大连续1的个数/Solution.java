package LeetCode.最大连续1的个数;

/**
 * @Author: hcb
 * @Date: 2021/2/5 16:43
 * @Version 1.0
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int slow = 0,fast = 0;
        int max_sum = 0;
        while (slow < n && fast < n) {
            while (slow < n && nums[slow] != 1) ++slow;
            if (slow + 1 == n) {
                max_sum = Math.max(max_sum,1);
                return max_sum;
            }
            if (slow >= n) return max_sum;
            fast = slow + 1;
            while (fast < n && nums[fast] == 1) {
                ++fast;
            }
            max_sum = Math.max(max_sum,fast - slow);
            slow = fast + 1;
        }
        return max_sum;
    }
}
