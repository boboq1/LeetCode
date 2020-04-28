package LeetCode.最长公共前缀;

import java.util.Arrays;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/3/2 17:34
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        Arrays.sort(strs);//按照字母的顺序排列字符串
        for(int i = 0; i< strs[0].length() ; i ++){
            if(strs[0].charAt(i) != strs[strs.length - 1].charAt(i))
                return strs[0].substring(0,i);
        }
        return strs[0];
    }
}
