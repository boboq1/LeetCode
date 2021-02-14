package LeetCode.二叉树.从前序与中序遍历序列构造二叉树;

import jdk.internal.org.objectweb.asm.tree.InnerClassNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hcb
 * @Date: 2021/2/14 13:08
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
   /* int[] preorder,inorder;
    int pre_idx;
    Map<Integer,Integer> idx_map = new HashMap<>();
    public TreeNode helper(int left_index,int right_index) {
        if (left_index > right_index) return null;
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);
        int index = idx_map.get(root_val);
        pre_idx++;
        root.left = helper(left_index, index - 1);
        root.right = helper(index + 1,right_index);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        pre_idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            idx_map.put(inorder[i],i);
        }
        return helper(0,inorder.length - 1);
    }*/
   public TreeNode buildTree(int[] preorder, int[] inorder) {
       Deque<TreeNode> stack = new ArrayDeque<>();
       int preorderIndex = 0;
       int inorderIndex = 0;
       if (inorder.length == 0) return null;
       TreeNode root = new TreeNode(preorder[preorderIndex]);
       stack.push(root);
       for (int i = 1; i < preorder.length; i++) {
           int node_val = preorder[i];
           TreeNode node = stack.peek();
           if (stack.peek().val != inorder[inorderIndex]) {
               node.left = new TreeNode(node_val);
               stack.push(node.left);
           } else {
               while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                   node = stack.pop();
                   inorderIndex++;
               }
               node.right = new TreeNode(node_val);
               stack.push(node.right);
           }
       }
       return root;
   }
}