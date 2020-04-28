//给定一个二叉搜索树的根结点 root，返回树中任意两节点的差的最小值。 
//
// 
//
// 示例： 
//
// 输入: root = [4,2,6,1,3,null,null]
//输出: 1
//解释:
//注意，root是树结点对象(TreeNode object)，而不是数组。
//
//给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \    
//    1   3  
//
//最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。 
//
// 
//
// 注意： 
//
// 
// 二叉树的大小范围在 2 到 100。 
// 二叉树总是有效的，每个节点的值都是整数，且不重复。 
// 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 
//相同 
// 
// Related Topics 树 递归

package LeetCode.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MinimumDistanceBetweenBstNodes{
      public static void main(String[] args) {
           Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
          List<Integer> list;
    public int minDiffInBST(TreeNode root) {
        list = new ArrayList<>();
        diffInBST(root);
        int min = Integer.MAX_VALUE;
        Collections.sort(list);
        for (int i = 0; i < list.size()-1; i++) {
            min = Math.min(min,list.get(i+1)-list.get(i));
        }
        return min;
    }
    public void diffInBST(TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        diffInBST(root.left);
        diffInBST(root.right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }