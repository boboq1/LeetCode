package LeetCode.栈.每日温度;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: hcb
 * @Date: 2021/2/25 19:11
 * @Version 1.0
 */
public class Solution {
    /*public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            stack.push(T[i]);
        }
        int[] res = new int[n];
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int index = stack.size();
            for (int i = index + 1;i < n;++i) {
                if (top < T[i]) {
                     res[index] = i - index;
                     break;
                }
            }
        }
        return res;
    }*/
    //单调栈
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] ans = new int[n];
        Deque<Integer> integerStack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!integerStack.isEmpty() && T[i] > T[integerStack.peek()]) {
                int index = integerStack.pop();
                ans[index] = i - index;
            }
            integerStack.push(i);
        }
        return ans;
    }
}
