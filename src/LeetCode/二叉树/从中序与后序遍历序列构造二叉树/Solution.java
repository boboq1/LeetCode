package LeetCode.二叉树.从中序与后序遍历序列构造二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hcb
 * @Date: 2021/2/11 10:21
 * @Version 1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    /*int post_index = 0;
    int[] inorder;
    int[] postorder;
    Map<Integer,Integer> idx_map = new HashMap<>();
    public TreeNode helper(int left_index,int right_index) {
        if (left_index > right_index) return null;
        int root_val = postorder[post_index];
        TreeNode node = new TreeNode(root_val);
        int index = idx_map.get(root_val);
        post_index--;
        node.right = helper(index + 1,right_index);
        node.left = helper(left_index,index - 1);
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        post_index = postorder.length - 1;
        for (int i = 0; i <= post_index; i++) {
            idx_map.put(inorder[i],i);
        }
        return helper(0,inorder.length - 1);
    }
    */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int inorderIndex = inorder.length - 1;
        int postorderIndex = postorder.length - 1;
        TreeNode root = new TreeNode(postorder[postorderIndex]);
        stack.push(root);
        for (int i = postorder.length - 2; i >= 0; i--) {
            int postorder_val = postorder[i];
            TreeNode node = stack.peek();
            if (stack.peek().val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorder_val);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                     node = stack.pop();
                     inorderIndex--;
                }
                node.left = new TreeNode(postorder_val);
                stack.push(node.left);
            }
        }
        return root;
    }
}
