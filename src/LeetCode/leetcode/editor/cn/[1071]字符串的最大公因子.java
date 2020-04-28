//对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。 
//
// 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。 
//
// 
//
// 示例 1： 
//
// 输入：str1 = "ABCABC", str2 = "ABC"
//输出："ABC"
// 
//
// 示例 2： 
//
// 输入：str1 = "ABABAB", str2 = "ABAB"
//输出："AB"
// 
//
// 示例 3： 
//
// 输入：str1 = "LEET", str2 = "CODE"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 1 <= str1.length <= 1000 
// 1 <= str2.length <= 1000 
// str1[i] 和 str2[i] 为大写英文字母 
// 
// Related Topics 字符串

package LeetCode.leetcode.editor.cn;
   class GreatestCommonDivisorOfStrings{
      public static void main(String[] args) {
           Solution solution = new GreatestCommonDivisorOfStrings().new Solution();
          System.out.println(solution.gcdOfStrings("ABABAB", "ABAB"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


          //辗转相除法
          public String gcdOfStrings(String str1, String str2) {

              if (!(str1+str2).equals(str2+str1)) return "";

              int len1 = Math.max(str1.length(),str2.length());
              int len2 = Math.min(str1.length(),str2.length());
              int i = helper(len1,len2);
              return str1.substring(0,i);
          }
          public int helper(int len1,int len2) {
              int temp = len1%len2;
              if (temp==0) return len2;
              return helper(len2,temp);
          }
//     方法一：枚举法
   /* public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int min = Math.min(len1,len2);
        for (int i = min; i >= 1; i--) {
            if (len1%i==0&&len2%i==0) {
                String temp = str1.substring(0,i);
                if (check(temp,str1) && check(temp,str2)) {
                    return temp;
                }
            }
        }

        return "";
    }
    public boolean check(String temp,String str) {
        int length = str.length()/temp.length();
        String ans = "";
        for (int i = 0; i < length; i++) {
            ans += temp;
        }
        return ans.equalsIgnoreCase(str);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

  }