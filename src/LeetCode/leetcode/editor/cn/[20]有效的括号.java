//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

package LeetCode.leetcode.editor.cn;

import java.util.Stack;

class ValidParentheses{
      public static void main(String[] args) {
           Solution solution = new ValidParentheses().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
   /* public boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            }else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty()|| c != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }*/
   public boolean isValid(String s) {
       if (s.isEmpty()) return true;
       Stack<Character> stack = new Stack<> ();
       for (char c : s.toCharArray()) {
           if (c == '('|| c == '{' || c == '[') {
               stack.push(c);
           } else {
               if (stack.isEmpty()) return false;
               char c1 = stack.pop();
               if (c == ')'&& c1 != '(') {
                   return false;
               }
               if (c == '}'&& c1 != '{') return false;
               if (c == ']' && c1 != '[') return false;
           }
       }
       return stack.isEmpty();
   }
}

//leetcode submit region end(Prohibit modification and deletion)

  }