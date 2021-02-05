package LeetCode.数组拆分I;

import java.util.Arrays;

/**
 * @Author: hcb
 * @Date: 2021/2/3 17:12
 * @Version 1.0
 */
public class Solution {
  /*  public int arrayPairSum1(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < n; i+=2) {
            result += nums[i];
        }
        return result;
    }
    public int arrayPairSum(int[] nums) {
        int[] arr = new int[20001];
        int lim = 10000;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            arr[lim + nums[i]]++;
        }
        int result = 0;
        int d = 0;
        for (int i = -10000; i <= 10000;++i) {
            result += (arr[i + lim] + 1 - d) / 2 * i;
            d = (2 + arr[i + lim] - d) % 2;
        }
        return result;
    }*/
    //方法三暴力破解
    int max_sum = Integer.MIN_VALUE;
  public int arrayPairSum(int[] nums) {
      permute(nums,0);
      return max_sum;
  }

    public void permute(int[] nums, int l) {
      if (l == nums.length - 1) {
          int sum = 0;
          for (int i = 0; i < nums.length / 2; i++) {
              sum += Math.min(nums[i], nums[i + nums.length / 2]);
          }
          max_sum = Math.max(max_sum,sum);
      }
        for (int i = l; i < nums.length; i++) {
            swap(nums[i],nums[l]);
            permute(nums,l + 1);
            swap(nums[l],nums[i]);
        }
    }
    public void swap(int x,int y) {
      int temp = x;
      x = y;
      y = temp;
    }
}
