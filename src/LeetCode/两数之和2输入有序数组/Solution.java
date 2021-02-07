package LeetCode.两数之和2输入有序数组;

import java.util.*;

/**
 * @Author: hcb
 * @Date: 2021/2/5 13:07
 * @Version 1.0
 */
public class Solution {

    public int[] twoSum1(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> indexToValue = new HashMap<>();
        Map<Integer, Integer> valueToCount = new HashMap<>();
        int n = numbers.length;
        int count = 1;
        for (int i = 0; i < n; i++) {
            indexToValue.put(count++, numbers[i]);
            int value = 0;
            if (valueToCount.containsKey(numbers[i])) {
                value = valueToCount.getOrDefault(numbers[i], 0) + 1;
                valueToCount.put(numbers[i], value);
            } else valueToCount.put(numbers[i], 1);
        }
        for (int i = 0; i < n; i++) {
            int sum = target - numbers[i];
            if (sum == numbers[i] && valueToCount.get(sum) >=2) {
                result[0] = i + 1;
                for (Map.Entry<Integer, Integer> entry : indexToValue.entrySet()) {
                    int key = entry.getKey();
                    int value = entry.getValue();
                    if (value == sum && key - 1 != i) {
                        result[1] = key;
                        return result;
                    }
                }
            }
            if (valueToCount.containsKey(sum)) {
                result[0] = i + 1;
                for (Map.Entry<Integer, Integer> entry : indexToValue.entrySet()) {
                    int key = entry.getKey();
                    int value = entry.getValue();
                    if (value == sum) {
                        result[1] = key;
                        return result;
                    }
                }
            }
        }
        return result;
    }
    public int[] twoSum2(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[i] + numbers[mid] == target) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[i] + numbers[mid] > target) {
                    high = mid;
                } else low = mid;
            }
        }
        return new int[] {-1,-1};
    }
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int start = 0, end = n - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) return new int[]{start + 1, end + 1};
            if (numbers[start] < target - numbers[end]) {
                ++start;
            }
            if (numbers[end] > target - numbers[start]) {
                --end;
            }
        }
        return new int[]{-1,-1};
    }
}
