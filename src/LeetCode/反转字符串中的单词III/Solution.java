package LeetCode.反转字符串中的单词III;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hcb
 * @Date: 2021/2/6 11:58
 * @Version 1.0
 */
public class Solution {
    public String reverseWords1(String s) {
        int n = s.length();
        if (n == 0) return s;
        String[] strings = s.split("\\s+");
        int str_len = strings.length;
        int start = 0;
        StringBuffer blankCount = new StringBuffer();
        List<String> blankList = new ArrayList<>();
        for (int i = 0; i < str_len; i++) {
            strings[i] = new StringBuilder(strings[i]).reverse().toString();
        }

        while (start < n) {
            while (start < n && s.charAt(start) != " ".charAt(0)) {
                ++start;
            }
            while (start < n && s.charAt(start) == " ".charAt(0)) {
                blankCount.append(" ");
                ++start;
            }
            blankList.add(blankCount.toString());
            blankCount = new StringBuffer();

        }
        StringBuilder copyS = new StringBuilder();
        for (int i = 0; i < (blankList.size() > str_len ? str_len : blankList.size()); i++) {
            if (s.charAt(0) == " ".charAt(0)) {
                copyS.append(blankList.get(i));
                copyS.append(strings[i]);
            } else {
                copyS.append(strings[i]);
                copyS.append(blankList.get(i));
            }
        }
        if (blankList.size() > str_len) copyS.append(blankList.get(blankList.size() - 1));
        if (blankList.size() < str_len) copyS.append(strings[str_len - 1]);
        return copyS.toString();
    }

    public String reverseWords2(String s) {
        StringBuffer ret = new StringBuffer();
        int n = s.length();
        int i = 0;
        while (i < n) {
            int start = i;
            while (i < n && s.charAt(i) != ' ') {
                ++i;
            }
            for (int j = start; j < i; j++) {
                ret.append(s.charAt(i - j + start - 1));
            }
            while (i < n && s.charAt(i) == ' ') {
                ret.append(' ');
                ++i;
            }
        }
        return ret.toString();
    }
    public String reverseWords(String s) {
        int n = s.length();
        char[] chars = new char[n];
        int start = 0;
        for (int i = 0; i < n; i++) {
            while (i < n && s.charAt(i) != ' ') {
                ++i;
            }
            for (int j = start; j < i; j++) {
                chars[j] = s.charAt(i - j + start - 1);
            }
           if (i < n - 1) {
               chars[i] = ' ';
               start = i + 1;
           }
        }
        String rat = new String(chars);
        return rat;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords1("Let's take LeetCode   contest").toString());

    }

}
