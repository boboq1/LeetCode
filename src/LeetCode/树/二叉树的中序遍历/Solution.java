package LeetCode.树.二叉树的中序遍历;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: hcb
 * @Date: 2021/2/8 20:22
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

class Solution {
    /*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        midOrder(root,result);
        return result;
    }

    private void midOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        midOrder(root.left,result);
        result.add(root.val);
        midOrder(root.right,result);
    }*/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node !=null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode top = stack.pop();
            result.add(top.val);
            node = top.right;
        }
        return result;
    }

}