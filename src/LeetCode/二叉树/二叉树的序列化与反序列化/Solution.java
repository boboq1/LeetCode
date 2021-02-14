package LeetCode.二叉树.二叉树的序列化与反序列化;

import java.util.*;

/**
 * @Author: hcb
 * @Date: 2021/2/14 17:58
 * @Version 1.0
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer ans = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                ans.append(node == null ? ' ' : node.val);
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int d = 0;
        Map<Integer,TreeNode> indexToNode = new HashMap<>();
        int n = data.length();
        while (d < n) {
            indexToNode.put(d,data.charAt(d) == ' ' ? null : new TreeNode(Integer.parseInt(String.valueOf(data.charAt(d)))));
            d++;
        }
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = indexToNode.get(0);
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    node.left = indexToNode.get(index++);
                    queue.offer(node.left);
                    node.right = indexToNode.get(index++);
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

}