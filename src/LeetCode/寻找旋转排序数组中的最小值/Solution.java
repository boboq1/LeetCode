package LeetCode.寻找旋转排序数组中的最小值;

import java.util.Arrays;

/**
 * @Author: hcb
 * @Date: 2021/2/7 9:28
 * @Version 1.0
 */
public class Solution {
    public int findMin1(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        Arrays.sort(nums);
        return nums[0];
    }
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        int minNum = Integer.MAX_VALUE;
        int start = 0;
        int end = n - 1;
        while (start < end) {
            int mid = (end - start + 1) / 2 + start;
            if (nums[start] <= nums[mid]) {
                minNum = Math.min(nums[start],minNum);
                start = mid + 1;
            }
            if (nums[mid] <= nums[end]) {
                minNum = Math.min(nums[mid],minNum);
                end = mid - 1;
            }
        }
        if (start < n )
        minNum = Math.min(minNum,nums[start]);
        return minNum;
    }
}
