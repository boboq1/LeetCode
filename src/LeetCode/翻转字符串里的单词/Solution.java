package LeetCode.翻转字符串里的单词;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: hcb
 * @Date: 2021/2/2 9:38
 * @Version 1.0
 */
public class Solution {
   /* public String reverseWords(String s) {
        if (s.length() == 0 || s == null) return "";
        List<String> word = new ArrayList<>();
        String blank = " ";
        for (int i = 0; i < s.length();) {
            StringBuffer str = new StringBuffer();
           while (i < s.length() && s.charAt(i) != blank.charAt(0)) {
               str.append(s.charAt(i));
               ++i;
           }
           if (str.length() != 0)word.add(str + " ");
           while (i < s.length() && s.charAt(i) == blank.charAt(0)) {
               ++i;
           }
        }
        StringBuffer result = new StringBuffer();
        for (int i = word.size() - 1; i >= 0; i--) {
            result.append(word.get(i));
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("'" + solution.reverseWords("  hello world  ") + "'");
    }*/
   public String reverseWords(String s) {
       if (s.length() == 0 || s == null) return "";
       s = s.trim();
       List<String> word = Arrays.asList(s.split("\\s+"));
       Collections.reverse(word);
       return String.join(" ",word);
   }
}
