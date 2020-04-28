//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索

package LeetCode.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.Stack;

class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    //  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        //递归
    /*public  int maxLength(TreeNode root){
        if (root == null) return -1;
        return 1+Math.max(maxLength(root.left),maxLength(root.right));
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null)return true;
        return Math.abs(maxLength(root.left)-maxLength(root.right))<2&&
                isBalanced(root.left)&& isBalanced(root.right);
    }*/
        class TreeNodeHelper {
            private int height;
            private boolean balanced;

            TreeNodeHelper(int height, boolean balanced) {
                this.height = height;
                this.balanced = balanced;
            }
        }

        private TreeNodeHelper helper(TreeNode root) {
            if (root == null) return new TreeNodeHelper(-1,true);
            TreeNodeHelper left = helper(root.left);
            if (!left.balanced){
                return new TreeNodeHelper(-1,false);
            }
            TreeNodeHelper right = helper(root.right);
            if (!right.balanced){
                return new TreeNodeHelper(-1,false);
            }
            if (Math.abs(left.height-right.height)<2){
                return new TreeNodeHelper(Math.max(left.height,right.height)+1,true);
            }
            return new TreeNodeHelper(-1,false);
        }

        public boolean isBalanced(TreeNode root) {
            return helper(root).balanced;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}