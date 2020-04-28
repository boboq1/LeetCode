package LeetCode.跳跃游戏;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/2/21 14:02
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int last = nums.length-1;
        int i = last;
       do {
           int sum = last - (--i);
           if (i==0 && sum>nums[0]){
               return false;
           }
           if (sum<=nums[i]){
               last = i;
           }

       }while (i!=0);
     return true;
    }
    public static void main(String[]ars){
        int[]nums = {3,2,1,1,4};
        System.out.println(new Solution().canJump(nums));
    }
}
