package LeetCode.二叉树.二叉树的最大深度;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: hcb
 * @Date: 2021/2/10 8:57
 * @Version 1.0
 */

   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;this.left = left;
          this.right = right;
      }}
class Solution {
    /*int max_depth = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        maxDepth(root,1);
        return max_depth;
    }

    private void maxDepth(TreeNode root, int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null) max_depth = Math.max(max_depth,depth);
        maxDepth(root.left,depth + 1);
        maxDepth(root.right,depth + 1);
    }*/
    //广度优先搜索
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = null;
           while (size > 0) {
                root = queue.poll();
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
                size--;
             }
           depth++;
        }
        return depth;
    }
}