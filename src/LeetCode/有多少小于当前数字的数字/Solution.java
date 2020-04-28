package LeetCode.有多少小于当前数字的数字;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/3/1 10:34
 */
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        if (nums.length==0)return null;
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int c = 1;
            while (c<nums.length){
                if (nums[i]>nums[c++])sum[i]++;
            }
        }
        return sum;
    }
}
