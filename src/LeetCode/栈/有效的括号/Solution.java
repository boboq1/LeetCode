package LeetCode.栈.有效的括号;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @Author: hcb
 * @Date: 2021/2/25 18:03
 * @Version 1.0
 */
public class Solution {
    /*public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 1;
        stack.push(s.charAt(0));
        while (i < s.length()) {
            char ch = s.charAt(i);
            i++;
            if (stack.isEmpty()) {
                if (ch == ')' || ch == ']' || ch == '}') return false;
                stack.push(ch);
                continue;
            }
            char top = stack.peek();
            if ((top == '(' && ch == ')') || (top == '[' && ch == ']') || (top == '{' && ch == '}')) {
                stack.pop();
            } else {
                if (ch == ')' || ch == ']' || ch == '}') return false;
                stack.push(ch);
            }

            if (i >= s.length() && stack.isEmpty()) return true;
        }
        return false;
    }*/
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) return false;
        Map<Character,Character> characterMap = new HashMap<>();
        characterMap.put(']','[');
        characterMap.put('}','{');
        characterMap.put(')','(');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (characterMap.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != characterMap.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

  /*  public static void main(String[] args) {
        Solution s = new Solution();
        s.isValid("()[]{}");
    }*/
}
