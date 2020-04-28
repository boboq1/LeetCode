package LeetCode.最长同值路径;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/2/16 10:02
 */
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    public void bianli(TreeNode node){
          TreeNode node1;
          while (node.val!=0){
              System.out.println(node.val);
              node = node.left;
          }
    }
    public static void main(String[]args){
      TreeNode node = new TreeNode(12);
      node.left = new TreeNode(32);
      node.right = new TreeNode(23);
      node.left.left = new TreeNode(43);
      if (node.val!=0){

      }
    }
  }
