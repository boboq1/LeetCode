package LeetCode.二叉树.二叉树的前序遍历;

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
   /* public List<Integer> preorderTraversal(TreeNode root) {
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
    }*/
    //Morris方法
      public List<Integer> preorderTraversal(TreeNode root) {
          List<Integer> res = new ArrayList<>();
          TreeNode p1 = root,p2 = null;
          while (p1 != null) {
              p2 = p1.left;
              if (p2 != null) {
                  while (p2.right != null && p2.right != p1) {
                      p2 = p2.right;
                  }
                  if (p2.right == null) {
                      res.add(p1.val);
                      p2.right = p1;
                      p1 = p1.left;
                      continue;
                  } else {
                      p2.right = null;
                  }
              } else {
                  res.add(p1.val);
              }
              p1 = p1.right;
          }
          return res;
      }

}