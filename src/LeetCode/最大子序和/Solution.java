package LeetCode.最大子序和;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/2/22 18:59
 * 动态规划
 */

public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i-1]>0)nums[i]+=nums[i-1];
            max = Math.max(max,nums[i]);
        }
        return max;
    }

    public static void main(String[]args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray(nums));
    }
}
