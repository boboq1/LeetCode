package LeetCode.树.二叉树的前序遍历;

import java.util.*;

/**
 * @Author: hcb
 * @Date: 2021/2/8 19:05
 * @Version 1.0
 */

  class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
  }

class Solution {
      //递归调用
    /*public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        reverse(root,result);
        return result;
    }

    private void reverse(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            reverse(root.left,result);
            reverse(root.right,result);
        }
    }*/
    //迭代：栈实现
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return result;
    }
}