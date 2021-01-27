package LeetCode.寻找数组的中心索引;

public class Solution {
    /*public int pivotIndex(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (sum(nums,i)) {
                return i;
            }
        }
            return -1;
    }
    public boolean sum(int[] nums,int index) {
        int sum = 0;
        for (int j = 0; j < index; j++) {
            sum += nums[j];
        }
        int next = index + 1;
        if (next < nums.length) {
            for (int i = next; i < nums.length; i++) {
                sum -= nums[i];
            }
        }

        return sum == 0?true:false;
    }*/
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
