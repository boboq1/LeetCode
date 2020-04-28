//给出二叉 搜索 树的根节点，该二叉树的节点值各不相同，修改二叉树，使每个节点 root 的新值等于原树中大于或等于 root.val 的值之和。
//
// 提醒一下，二叉搜索树满足下列约束条件： 
//
// 
// 节点的左子树仅包含键 小于 节点键的节点。 
// 节点的右子树仅包含键 大于 节点键的节点。 
// 左右子树也必须是二叉搜索树。 
// 
//
// 
//
// 示例： 
//
// 
//
// 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数介于 1 和 100 之间。 
// 每个节点的值介于 0 和 100 之间。 
// 给定的树为二叉搜索树。 
// 
//
// 
//
// 注意：该题目与 538: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/ 相同
// 
// Related Topics 二叉搜索树

package LeetCode.leetcode.editor.cn;

class BinarySearchTreeToGreaterSumTree {
    public static void main(String[] args) {
        Solution solution = new BinarySearchTreeToGreaterSumTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    // Definition for a binary tree root.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        //方法一：找最大的节点并填充赋值
   /* public TreeNode bstToGst(TreeNode root) {
        faM(root,0);
        return root;
    }

    private int faM(TreeNode root, int i) {
        if (root == null) return i;
        root.val += faM(root.right,i);
        return  faM(root.left,root.val);

    }*/
       private int lastVal = 0;
        public TreeNode bstToGst(TreeNode root) {
            traverse(root);
            return root;
        }

        private void traverse(TreeNode root) {
            if (root == null) return;
            traverse(root.right);
            root.val += lastVal;
            lastVal = root.val;
            traverse(root.left);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}