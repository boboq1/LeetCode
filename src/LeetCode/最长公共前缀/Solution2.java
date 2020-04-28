package LeetCode.最长公共前缀;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/3/2 16:14
 *水平扫描优化：比较每个字符的列，扫描整个数组
 * 时间复杂度：O(S) S是所有字符串字符数量的总和 m*n
 */
public class Solution2 {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null|| strs.length==0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                while (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
