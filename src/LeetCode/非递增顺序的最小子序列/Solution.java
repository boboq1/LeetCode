package LeetCode.非递增顺序的最小子序列;
import	java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/4/5 10:49
 */
public class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> sonSeq = new ArrayList<Integer> ();
        if (nums.length == 0 || nums == null) return sonSeq;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int least = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            least += nums[i];
            sonSeq.add(nums[i]);
            if (sum - least < least) {
                break;
            }
        }
        return sonSeq;
    }
}
