//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表

package LeetCode.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion) O(nlogn)
    class Solution {
        //          方法一
    /*public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())return false;
        char[] tchars = t.toCharArray();
        char[] schars = s.toCharArray();

        Arrays.sort(tchars);
        Arrays.sort(schars);
        return Arrays.equals(tchars,schars);
    }*/
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length())return false;
            int[] counter = new int[26];
            for (int i = 0; i < s.length(); i++) {
             counter[s.charAt(i)-'a']++;
             counter[t.charAt(i)-'a']--;
            }
            for (int i : counter) {
                if (i!=0)return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}