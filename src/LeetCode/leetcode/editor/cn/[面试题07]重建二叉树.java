
package LeetCode.leetcode.editor.cn;
import	java.util.Stack;//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class ZhongJianErChaShuLcof{
      public static void main(String[] args) {
           Solution solution = new ZhongJianErChaShuLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
  Definition for a binary tree node.**/
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    /*public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        Map<Integer,Integer> inMap = new HashMap<Integer, Integer>();
        int len = preorder.length;
        for (int i = 0; i < len; i++) {
            inMap.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1,inMap);
    }

    private TreeNode helper(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd, Map<Integer, Integer> inMap) {

        if (preBegin > preEnd) return null;
        int rootValue = preorder[preBegin];
        TreeNode root = new TreeNode(rootValue);
        if (preBegin == preEnd) {
            return root;
        }else  {
            int indexRoot = inMap.get(rootValue);
            int leftTree = indexRoot - inBegin;
            int rightTree = inEnd - indexRoot;
            TreeNode leftTreeNode = helper(preorder,preBegin + 1,preBegin + leftTree,
                    inorder,inBegin,indexRoot-1,inMap);
            TreeNode rightTreeNode = helper(preorder,preEnd-rightTree+1,preEnd,
                    inorder,indexRoot + 1,inEnd,inMap);
            root.left = leftTreeNode;
            root.right = rightTreeNode;
            return root;
        }
    }*/
    //迭代法
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        Stack<TreeNode> stack = new Stack<> ();
        int inOrderIndex = 0;
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inOrderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inOrderIndex]) {
                    node = stack.pop();
                    inOrderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }