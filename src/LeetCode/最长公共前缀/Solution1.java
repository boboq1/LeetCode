package LeetCode.最长公共前缀;

/*
* 水平扫描法
* 时间复杂度：O(S) S是所有字符串字符数量的总和
* 空间复杂度：O(1)
* */
public class Solution1 {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(str)!=0) {
                str = str.substring(0,str.length()-1);
                if (str=="") return "";
            }
        }

        return str;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        String[]strs = {"abcde","a","abc"};
        System.out.println(s.longestCommonPrefix(strs));
    }
}
