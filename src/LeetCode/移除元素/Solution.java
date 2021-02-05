package LeetCode.移除元素;

/**
 * @Author: hcb
 * @Date: 2021/2/5 16:11
 * @Version 1.0
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;
        while (slow < n && fast < n) {
            while (slow < n && nums[slow] != val) ++slow;
            if (fast < slow ) fast = slow + 1;
            if (fast < n) {
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    nums[fast] = val;
                } else {
                    ++fast;
                }
            }
        }
        return slow;
    }
}
