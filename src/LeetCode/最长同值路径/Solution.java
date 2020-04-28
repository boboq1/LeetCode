package LeetCode.最长同值路径;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/2/16 10:02
 */
public class Solution {
    int length=0;
    public int longestUnivaluePath(TreeNode root) {
       postOrder(root,root.val);
       return length;
    }
    private int postOrder(TreeNode root, int val){
        if (root==null){
            return 0;
        }
        int left = postOrder(root.left,root.val);
        int right = postOrder(root.right,root.val);
        length = Math.max(length,left+right);
        if (root.val == val){
            return Math.max(left,right)+1;
        }
        return 0;
    }
}
