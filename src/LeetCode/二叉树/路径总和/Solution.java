package LeetCode.二叉树.路径总和;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: hcb
 * @Date: 2021/2/10 18:38
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
    /*public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }*/
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueVal = new LinkedList<>();
        queueNode.offer(root);
        queueVal.offer(root.val);
        while (!queueNode.isEmpty()) {
            TreeNode top = queueNode.poll();
            Integer temp = queueVal.poll();
            if (top.left == null && top.right == null) {
                if (temp == targetSum) {
                    return true;
                }
                continue;
            }
            if (top.left != null) {
                queueNode.offer(top.left);
                queueVal.offer(temp + top.left.val);
            }
            if (top.right != null) {
                queueNode.offer(top.right);
                queueVal.offer(temp + top.right.val);
            }
        }
        return false;
    }
}