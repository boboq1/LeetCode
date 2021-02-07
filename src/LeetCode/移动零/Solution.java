package LeetCode.移动零;

import java.text.SimpleDateFormat;

/**
 * @Author: hcb
 * @Date: 2021/2/7 11:06
 * @Version 1.0
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 1;
        while (fast < n) {
            while (slow < n && nums[slow] != 0) {
                slow++;
            }
            if (fast <= slow)fast = slow + 1;
            while (fast < n && nums[fast] != 0 ) {
                nums[slow] = nums[fast];
                nums[fast] = 0;
                slow++;
                fast++;
            }
            fast++;
        }
    }
}
