package LeetCode.单调栈.接雨水;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: hcb
 * @Date: 2021/2/25 19:59
 * @Version 1.0
 */
public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(height[0]);
        int ans = 0;
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && i < n && height[i] < height[stack.peek()]) {
                ++i;
            }
            int index = stack.pop();
            stack.push(i);
            ans += helper(index,i,height);
        }
        return ans;
    }
    public int helper(int start,int end,int[] height) {
        int n = height.length;
        end = end - 1;
        int len = end - start;
        int count = start * len;
        for (int i = start + 1;i <= end;++i) {
            count -= height[i];
        }
        return count;
    }
}
