package 数组练习.旋转数组;

public class Solution {
    /*public void rotate(int[] nums){
        int temp = 0;
        if (nums.length > 1){
            temp =  nums[nums.length - 1];
            for (int i = nums.length - 1; i >= 0;) {
                nums[i] = nums[--i];
                if (i == 0) {
                    nums[i] = temp;
                    i--;
                }
            }
        }


    }
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            rotate(nums);
        }
    }*/
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        int temp = 0;
        for (;i<=j;i++){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j--;
        }
    }
}