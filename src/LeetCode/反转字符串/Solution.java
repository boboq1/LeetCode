package LeetCode.反转字符串;

/**
 * @Author: hcb
 * @Date: 2021/2/3 17:05
 * @Version 1.0
 */
public class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int start = 0, end = n - 1;
        while (start <= end ) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            ++start;
            --end;
        }
    }
}
