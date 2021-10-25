package LeetCode.h230字符串解码;

/**
 * @Auther: 13771
 * @Date: 2021/10/22 21:44
 * @Description: Solution
 * @Version 1.0.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
    }

    /*public String decodeString(String s) {
        int n = s.length();
        StringBuilder temp;
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < n) {
            if (']' != s.charAt(i)) {
                stack.add(s.charAt(i));
            } else {
                temp = new StringBuilder();
                while (stack.peek() != '[') {
                    temp.append(stack.pop());
                }
                temp.reverse();
                stack.pop();
                int times = 0;
                StringBuilder num = new StringBuilder();
                while (!stack.empty() && stack.peek() >= 48 && stack.peek() <= 57) {
                    num.append(stack.pop());
                }
                num.reverse();
                for (int a = 0; a < num.length(); a++) {
                    times = times * 10 + num.charAt(a) - '0';
                }

                for (int j = 0; j < times; j++) {
                    for (int t = 0; t < temp.length(); t++) {
                        stack.add(temp.charAt(t));
                    }
                }
            }
            i++;
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.empty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }*/
    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }

    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int muti = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                muti = muti * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            } else if (s.charAt(i) == '[') {
                String[] temp = dfs(s, i + 1);
                i = Integer.parseInt(temp[0]);
                while (muti > 0) { //如果这里设置为muti--，则while 循环后 muti = -1;影响上边的导致上边的muti中加了负数,所以在while后把mult置为0
                    res.append(temp[1]);
                    muti--;
                }
//                muti = 0;
            } else if (s.charAt(i) == ']') {
                return new String[]{String.valueOf(i), res.toString()};
            } else {
                res.append(s.charAt(i));
            }
            i++;
        }
        return new String[]{res.toString()};
    }
}
