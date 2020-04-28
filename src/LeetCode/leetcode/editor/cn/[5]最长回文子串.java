//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

package LeetCode.leetcode.editor.cn;

class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*public String longestPalindrome(String s) {
            if (s.length() == 0 || s == null) return s;
            String ans = "";
            String reverse = new StringBuffer(s).reverse().toString();
            int len = s.length();
            int[][] arrs = new int[len][len];
            if (s.charAt(0) == reverse.charAt(0)) arrs[0][0] = 1;
            int max = arrs[0][0];
            int index = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (s.charAt(i) == reverse.charAt(j)) {
                        if (i == 0 || j == 0) {
                            arrs[i][j] = 1;
                        } else {
                            arrs[i][i] = arrs[i - 1][i - 1] + 1;
                        }
                    }
                    if (max < arrs[i][j]) {
                        int pre = len - 1 - j;
                        if (pre + arrs[i][j] - 1 == i) {
                            max = arrs[i][j];
                            index = i;
                        }
                    }

                }
            }
            return s.substring(index - max + 1, index + 1);
        }*/

        public String longestPalindrome(String s) {
            if (s.length() == 0 || s == null) return "";
            int len = s.length();
            int maxLen = 0;
            int maxStart = 0;
            int maxRight = 0;
            boolean[][] dp = new boolean[len][len];
            for (int i = 1; i < s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                        dp[j][i] = true;
                        if (maxLen < i - j + 1) {
                            maxLen = i - j + 1;
                            maxStart = j;
                            maxRight = i;
                        }
                    }
                }
            }
            return s.substring(maxStart, maxRight + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}