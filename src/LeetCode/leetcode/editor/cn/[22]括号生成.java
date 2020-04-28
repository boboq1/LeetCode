package LeetCode.leetcode.editor.cn;
import java.util.*;

//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法


class GenerateParentheses {

    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            if (n==0)return list;
            dfs("",n,n,list);
            return list;
        }

        private void dfs(String cur, int l, int r, List<String> list) {
            if (l==0&&r==0){
                list.add(cur);
                return;
            }
            if (l>r)return;
            if (l>0)dfs(cur+"(",l-1,r,list);
            if (r>0)dfs(cur+")",l,r-1,list);
        }
       /* public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            if (n == 0) return result;

            dfs("", n, n,result);
            return result;
        }

        private void dfs(String currentStr, int left, int right, List<String> result) {
            if (left == 0 && right == 0) {
                result.add(currentStr);
                return;
            }
            if (left > right) return;
            if (left > 0) dfs(currentStr + "(",left-1,right,result);
            if (right > 0) dfs(currentStr + ")",left,right-1,result);
        }*/
       //dfs
      /*class Node {
          private int left;
          private int right;
          private String value;
          Node(int left,int right,String value){
              this.left =left;
              this.right = right;
              this.value = value;
          }
       }
       public List<String> generateParenthesis(int n) {
           List<String>list = new ArrayList<>();
          if (n==0)return list;
          Deque<Node> stack = new ArrayDeque<> ();
          stack.addLast(new Node(n,n,""));
          while (!stack.isEmpty()){
              Node node =  stack.removeLast();
              if (node.left==0&&node.right==0){
                  list.add(node.value);
              }
              if (node.left>0)stack.addLast(new Node(node.left-1,node.right,node.value+"("));
              if (node.right>0&&node.right>node.left) stack.addLast(new Node(node.left,node.right-1,node.value+")"));
          }
          return list;
       }*/

       /*public List<String> generateParenthesis(int n) {
           List<List<String>> dp = new ArrayList<>(n);
           List<String> dp0 =  new ArrayList<>();
           dp0.add("");
           if (n==0)return dp0;
           dp.add(dp0);
           for (int i = 1; i <= n; i++) {
               List<String> cur = new ArrayList<>();
               for (int j = 0; j < i; j++) {
                   List<String> dp1 = dp.get(j);
                   List<String> dp2 = dp.get(i-j-1);
                   for (String s : dp1) {
                       for (String s1 : dp2) {
                           cur.add("("+s+")"+s1);
                       }
                   }
               }
               dp.add(cur);
           }
           return dp.get(n);
        }*/

    }
//leetcode submit region end(Prohibit modification and deletion)

}