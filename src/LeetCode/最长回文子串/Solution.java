package LeetCode.最长回文子串;

/**
 * @Author: hcb
 * @Date: 2021/1/30 16:39
 * @Version 1.0
 */
public class Solution {
    /*public String longestPalindrome(String s) {
        int n = s.length();
        if (s == null || n == 0) return "";
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                }else if (l == 1) dp[i][j] = s.charAt(i) == s.charAt(j);
                else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }*/
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) return "";
        int start = 0;
        int end = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int len1 = longestPalindrome(s,i,i);
            int len2 = longestPalindrome(s,i,i+1);
            int len = Math.max(len1,len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start,end + 1);
    }

    private int longestPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}
