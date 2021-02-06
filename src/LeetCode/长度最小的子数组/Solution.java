package LeetCode.长度最小的子数组;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEConfig;

/**
 * @Author: hcb
 * @Date: 2021/2/5 17:12
 * @Version 1.0
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min_len = Integer.MAX_VALUE;
        int n = nums.length;
        int slow = 0,fast = 0,sum = 0;
        while (fast < n) {
            sum += nums[fast];
            while (sum >= target) {
                min_len = Math.min(min_len, fast - slow + 1);
                sum -= nums[slow++];
            }
            ++fast;
        }

        return min_len == Integer.MAX_VALUE?0:min_len;
    }
}
