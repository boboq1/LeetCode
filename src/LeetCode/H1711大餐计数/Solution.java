package LeetCode.H1711大餐计数;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hechenbo
 * @Description: Define a class
 * @DateTime: 2021/7/7 14:49
 **/
public class Solution {
    public int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
      int n = deliciousness.length;
      Map<Integer,Integer> integerMap = new HashMap<>();//存放val:count
        //结果
        int result = 0;
        //取数组中的最大值
        int maxVal = 0;
        for (int delicious : deliciousness) {
            maxVal = Math.max(delicious,maxVal);
        }
        //两数之和最大值
        int maxSum = maxVal * 2;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum < maxSum; sum<<=1) {
                int count = integerMap.getOrDefault(sum - val,0);
                result = (result + count) % MOD;
            }
            integerMap.put(val,integerMap.getOrDefault(val,0) + 1);
        }
        return result;
    }
}
