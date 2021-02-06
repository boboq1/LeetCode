package LeetCode.杨辉三角II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: hcb
 * @Date: 2021/2/6 11:33
 * @Version 1.0
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int numRows = rowIndex + 1;
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        for (int i = 2; i <= numRows; i++) {
            Integer[] temp = new Integer[i];
            for (int j = 0; j < i; j++) {
                if (j == 0) temp[j] = 1;
                else if (j == i - 1) temp[j] = 1;
                else if (j - 1 >=0 && j < nums.size()) temp[j] = nums.get(j - 1) + nums.get(j);
            }
            nums = new ArrayList<>(i);
            Collections.addAll(nums,temp);
            if (i == numRows) return nums;
        }
        return nums;
    }
}
