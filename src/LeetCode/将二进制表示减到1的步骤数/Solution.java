package LeetCode.将二进制表示减到1的步骤数;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/4/5 11:03
 */
public class Solution {
   /* public int numSteps(String s) {

        int step = 0;
        int len = s.length() - 1;
        char[] chars = s.toCharArray();
        while (len > 0) {
            if (chars[len] == '0') {
                step++;
                if (--len == 0) return step;
            }else {
                step++;
                while (len >= 0 && chars[len]=='1') {
                    step++;
                    len --;
                }
                if (len < 0)return step;
                chars[len] = '1';
            }
        }
        return step;
    }*/

    //method2
   /* public int numSteps(String s) {
        if (s.length() == 0)return 0;
        char[]chars = s.toCharArray();
        int charry = 0;
        int step = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (i == 0 && charry == 0)return step;
            if (chars[i] - '0' != charry) {
                step++;
                charry = 1;
            }
            step++;
        }
        return step;
    }*/
}
