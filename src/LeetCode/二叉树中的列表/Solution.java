package LeetCode.二叉树中的列表;


/**
 * @author Admin
 * @version 1.0
 * @date 2020/3/1 10:56
 */
public class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {

        if (head == null||root == null) return false;

        return helper(head,root);
    }
    /*
    * 先判断左右head?=root
    * 其次*/
    public boolean helper(ListNode head,TreeNode root) {

        if (head==null) return true;
        if (head!=null&&root==null) return false;
                if (head.val == root.val){
                    helper(head.next,root.left);
                    helper(head.next,root.right);
                    return helper(head.next,root.left)==helper(head.next,root.right)&&
                            helper(head.next,root.left)==false?false:true;
                }else {
                    helper(head,root.left);
                    helper(head,root.right);
                    return helper(head,root.left)==helper(head,root.right)&&
                            helper(head,root.left)==false?false:true;
                }

    }

}
