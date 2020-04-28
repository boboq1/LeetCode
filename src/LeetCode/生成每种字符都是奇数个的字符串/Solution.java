package LeetCode.生成每种字符都是奇数个的字符串;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/3/8 10:33
 */
public class Solution {
    public String generateTheString(int n) {

        StringBuffer num = new StringBuffer();
        if (n%2==0) {
            for (int i = 1; i <= n-1 ; i++) {
               num.append("a");
            }
            return num.toString()+"b";
        }
        for (int i = 1; i < n-2; i++) {
            num.append("a");
        }
        return num.toString()+"b"+"c";
    }
}
