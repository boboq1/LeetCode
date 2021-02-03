package LeetCode.实现strStr;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @Author: hcb
 * @Date: 2021/2/2 12:42
 * @Version 1.0
 */
public class Solution {
    //失败案例
    /*public int strStr(String haystack, String needle) {
        if (needle == "") return 0;
        if (haystack.length() == 0 || haystack == null || haystack.length() < needle.length()) return -1;
        Deque<Character> haystackDeque = new ArrayDeque<>();
        for (int i = 0; i < haystack.length(); i++) {
            haystackDeque.add(haystack.charAt(i));
        }
        int count = 0;
        int i = 0;
        while (!haystackDeque.isEmpty()) {
            char c = haystackDeque.pop();
            ++count;
            if (c == needle.charAt(i)) {
                if (++i >= needle.length()) return count - i;
            } else {
              i = 0;
            }
        }
       return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("mississippi","issip" ));
    }*/
    //以下成功
    public int charToIndex(int i,String s){
        return s.charAt(i) - 'a';
    }
    public int strStr1(String haystack, String needle) {
        int L = needle.length();
        int N = haystack.length();
        if (N < L) return -1;
        long moudles = (long) Math.pow(2,31);
        int a = 26;
        long h = 0, ref_h = 0;
        for (int i = 0; i < L; i++) {
            h = (a*h + charToIndex(i,haystack)) % moudles;
            ref_h = (a*ref_h + charToIndex(i,needle)) % moudles;
        }
        if (h == ref_h) return 0;
        long aL = 1;
        for (int i = 1; i <= L; i++) {
            aL = (aL * a) % moudles;
        }
        for (int i = 1; i < N - L + 1; i++) {
            h = (h*a - charToIndex(i - 1,haystack) * aL + charToIndex(i + L - 1,haystack)) % moudles;
            if (h == ref_h) return i;
        }
        return -1;
    }
    //双指针
    public int strStr2(String haystack, String needle) {
        int L = needle.length();
        int N = haystack.length();
        if (L == 0) return 0;
        int pn = 0;

        while (pn < N - L + 1) {
            while (pn < N - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;
            int pl = 0;
            int cur_len = 0;
            while (pl < L && pn < N && haystack.charAt(pn) == needle.charAt(pl)) {
                ++pn;
                ++pl;
                ++cur_len;
            }
            if (cur_len == L) return pn - L;
            pn = pn - cur_len + 1;
        }
        return -1;
    }
    //滑动窗口
    public int strStr(String haystack, String needle) {
        int L = needle.length();
        int n = haystack.length();
        for (int i = 0; i < n - L + 1; i++) {
            if (haystack.substring(i,i + L + 1).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}

