package LeetCode.删除排序数组中的重复项;

/**
 * @Author: hcb
 * @Date: 2021/2/7 10:28
 * @Version 1.0
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 1;
        if (n == 1 || n == 0) return n;
        while (fast < n) {
            if (nums[fast] == nums[slow]) {
                fast++;
            } else {
                if (fast - slow > 1) {
                    nums[slow + 1] = nums[fast++];
                }
                slow++;
            }
        }
        return slow + 1;
    }
}
