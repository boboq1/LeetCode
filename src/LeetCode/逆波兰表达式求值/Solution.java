package LeetCode.逆波兰表达式求值;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;
        Set<String> tokenSet = new HashSet<>();
        tokenSet.add("+");
        tokenSet.add("-");
        tokenSet.add("/");
        tokenSet.add("*");
        for (int i = 0; i < n; i++) {
            if (!tokenSet.contains(tokens[i])) {
                stack.add(Integer.parseInt(tokens[i]));
            } else {
                if (stack.size() >= 2) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    switch (tokens[i]) {
                        case "+":
                            stack.add(num1 + num2);
                            break;
                        case "-":
                            stack.add(num2 - num1);
                            break;
                        case "*":
                            stack.add(num2 * num1);
                            break;
                        case "/":
                            stack.add(num2 / num1);
                            break;
                    }
                }
            }
        }
        return stack.pop();
    }
}
