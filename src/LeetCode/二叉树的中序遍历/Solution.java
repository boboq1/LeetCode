package LeetCode.二叉树的中序遍历;

import java.util.*;

/**
 * @Author: hechenbo
 * @Description: 中序遍历
 * @DateTime: 2021/7/19 14:16
 **/

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

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> deque = new Stack<>();
        List<Integer> sum = new ArrayList<>();
        while (root != null ||!deque.isEmpty()) {
            while (root != null) {
                deque.add(root);
                root = root.left;
            }
            TreeNode node = deque.pop();
            sum.add(node.val);
            root = node.right;
        }
        return sum;
    }
}
