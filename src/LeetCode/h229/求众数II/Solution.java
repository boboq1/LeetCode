package LeetCode.h229.求众数II;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 13771
 * @Date: 2021/10/22 20:21
 * @Description: Solution
 * @Version 1.0.0
 */
public class Solution {

    /*public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int time = n / 3;
        List<Integer> sum = new ArrayList<>();
        Map<Integer, Integer> times = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; ++i) {
            if (!sum.contains(nums[i])) {
                if (times.containsKey(nums[i])) {
                    int count = times.getOrDefault(nums[i], 0) + 1;
                    if (count > time) sum.add(nums[i]);
                    else times.put(nums[i], count);
                } else {
                    if (time < 1) sum.add(nums[i]);
                    times.put(nums[i], 1);
                }
            }
        }
        if (times.getOrDefault(nums[n - 1], 0) > time && !sum.contains(nums[n - 1])) {
            sum.add(nums[n - 1]);
        }
        return sum;
    }*/
//    摩尔投票法
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int element1 = 0, element2 = 0;
        int vote1 = 0, vote2 = 0;
        List<Integer> sum = new ArrayList<>();
        for (int num : nums) {
            if (vote1 > 0 && element1 == num) {
                vote1++;
            } else if (vote2 > 0 && element2 == num) {
                vote2++;
            } else if (vote1 == 0) {
                vote1 = 1;
                element1 = num;
            } else if (vote2 == 0) {
                vote2 = 1;
                element2 = num;
            } else {
                vote1--;
                vote2--;
            }
        }
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && element1 == num) {
                count1++;
            } else if (vote2 > 0 && element2 == num) {
                count2++;
            }
        }
        if (count1 > n / 3) sum.add(element1);
        if (count2 > n / 3) sum.add(element2);
        return sum;
    }

}
