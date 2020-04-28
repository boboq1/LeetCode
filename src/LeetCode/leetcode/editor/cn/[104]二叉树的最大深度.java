
//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索

package LeetCode.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Stack;

class MaximumDepthOfBinaryTree{
      public static void main(String[] args) {
           Solution solution = new MaximumDepthOfBinaryTree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)

//  Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution {
    //方法以递归
    public int maxDepth(TreeNode root) {

        if (root == null) return 0;
        int depth = 0;
        return helper(root,depth);
    }

    private int helper(TreeNode root, int depth) {
        if (root == null) return 0;
        int left = helper(root.left,depth);
        int right = helper(root.right,depth);
        depth = left<=right?right:left;
        return ++depth;
    }
   //BFS
    /*public int maxDepth(TreeNode root) {
        if (root == null)return 0;
        int depth = 0;
        LinkedList<TreeNode> queue = new LinkedList<> ();
        queue.add(root);
        while (!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return depth;
    }*/
    //dfs
    /*public int maxDepth(TreeNode root) {
        if (root == null)return 0;
        Stack<Pair<TreeNode,Integer>>stack = new Stack<>();
        stack.push(new Pair<>(root,1));
        int maxDepth = 0;
        while (!stack.isEmpty()){
            Pair<TreeNode,Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();
            maxDepth = Math.max(maxDepth,depth);
            if (node.left != null){
                stack.push(new Pair<>(node.left,depth+1));
            }
            if (node.right != null){
                stack.push(new Pair<>(node.right,depth+1));
            }

        }
        return maxDepth;
    }
*/
}
//leetcode submit region end(Prohibit modification and deletion)

  }