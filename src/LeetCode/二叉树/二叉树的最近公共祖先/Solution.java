package LeetCode.二叉树.二叉树的最近公共祖先;

import java.util.*;

/**
 * @Author: hcb
 * @Date: 2021/2/14 16:47
 * @Version 1.0
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    /*private TreeNode ans = null;
    public boolean dfs(TreeNode root,TreeNode p,TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left,p,q);
        boolean rson = dfs(root.right,p,q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.ans = null;
         dfs(root,p,q);
        return ans;
    }*/
    Map<Integer,TreeNode> valToNode = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public void dfs(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                valToNode.put(root.left.val,root);
                dfs(root.left);
            }
            if (root.right != null) {
                valToNode.put(root.right.val,root);
                dfs(root.right);
            }
        }

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (q != null) {
            visited.add(q.val);
            q = valToNode.get(q.val);
        }
        while (p != null) {
            if (visited.contains(p.val)) {
                return p;
            }
            p = valToNode.get(p.val);
        }
        return null;
    }
}