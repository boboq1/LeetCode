package LeetCode.二叉树.对称二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: hcb
 * @Date: 2021/2/10 9:53
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
   /* public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root,root);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val)
                && isSymmetric(left.left,right.right)
                && isSymmetric(left.right,right.left);
    }*/
   public boolean isSymmetric(TreeNode root) {
       if (root == null) return true;
       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       queue.offer(root);
       while (!queue.isEmpty()) {
           TreeNode node1 = queue.poll();
           TreeNode node2 = queue.poll();
           if (node1 == null && node2 == null) continue;
           if ((node1 == null || node2 == null ) || (node1.val != node2.val)) return false;
           queue.offer(node1.left);
           queue.offer(node2.right);
           queue.offer(node1.right);
           queue.offer(node2.left);
       }
       return true;
   }

}
