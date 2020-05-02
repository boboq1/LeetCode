//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

package LeetCode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
       /* int i = 0,j = 0;
        int n = s.length();
        int ans = 0;
        Set<Character> set = new HashSet<> ();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;*/
            //暴力破解
           /* int len = s.length();
            if (len <= 1) return len;
            int max = 0;
            int res = 0;
            int t = 0;
            for (int i = 1; i < len; i++) {
                for (int j = t; j < i; j++) {
                    if (s.charAt(i) != s.charAt(j)) {
                        res++;
                        if (j + 1 == i) {
                            max = Math.max(max, res + 1);
                            res = 0;
                        }
                    } else {
                        max = Math.max(max, res);
                        res = 0;
                        t = j + 1;
                        if (j + 1 == i) {
                            max =Math.max(max,res+1);
                        }
                    }
                   if (j+1==i)res = 0;
                }
            }
            return max;*/
            //滑动窗口
         /*   int len = s.length(), ans = 0;
            Set<Character> set = new HashSet<> ();
            int idl = -1;
            for (int i = 0; i < len; i++) {
                if (i != 0){
                    set.remove(s.charAt(i-1));
                }
                while (idl + 1 < len && !set.contains(s.charAt(idl + 1))){
                    set.add(s.charAt(idl + 1));
                    ++idl;
                }
                ans = Math.max(ans,idl - i + 1);
            }
            return ans;*/
           /* int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int end = 0, start = 0; end < n; end++) {
                char alpha = s.charAt(end);
                if (map.containsKey(alpha)) {
                    start = Math.max(map.get(alpha), start);
                }
                ans = Math.max(ans, end - start + 1);
                map.put(s.charAt(end), end + 1);
            }
            return ans;*/
            /*int i = 0;
            int flag = 0;
            int length = 0;
            int result = 0;
            while (i < s.length()) {
                int pos = s.indexOf(s.charAt(i),flag);
                if (pos < i) {
                    if (length > result) {
                        result = length;
                    }
                    if (result >= s.length() - pos - 1) {
                        return result;
                    }
                    length = i - pos - 1;
                    flag = pos + 1;
                }
                length++;
                i++;
            }
            return length;*/


            int len = s.length();
            int length = 0,res = 0;
            int flag = 0;
            int i = 0;
            while (i < len){
                int pos = s.indexOf(s.charAt(i),flag);
                if (pos < i){
                    if ((res = Math.max(res,length))>=s.length()-pos-1){
                        return res;
                    }
                    flag = pos + 1;
                    length = i - pos - 1;
                }
                length++;
                ++i;
            }
            return length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}