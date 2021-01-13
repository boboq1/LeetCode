package 数组练习.存在重复元素;

import java.util.HashSet;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> elements = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (elements.contains(nums[i])) {
                return true;
            }
            elements.add(nums[i]);
        }
        return false;
    }
}
