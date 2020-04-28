//二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。 
//
// 只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。 
//
// 如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。 
//
// 注意：节点没有值，本问题中仅仅使用节点编号。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
//输出：false
// 
//
// 示例 3： 
//
// 
//
// 输入：n = 2, leftChild = [1,0], rightChild = [-1,-1]
//输出：false
// 
//
// 示例 4： 
//
// 
//
// 输入：n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^4 
// leftChild.length == rightChild.length == n 
// -1 <= leftChild[i], rightChild[i] <= n - 1 
// 
// Related Topics 图

package LeetCode.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class ValidateBinaryTreeNodes{
      public static void main(String[] args) {
           Solution solution = new ValidateBinaryTreeNodes().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        /*首先找出所有节点的入度
         * 放入数组degs*/
        int[]degs = new int[n];
        for (int i = 0; i < n ; i++) {
            if (leftChild[i]!=-1) degs[leftChild[i]]++;
            if (rightChild[i]!=-1) degs[rightChild[i]]++;
        }

        /*其次，找到degs中入度为零的节点，即根节点*/
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (degs[i]==0) {
                root = degs[0];
                break;
            }
        }
        if (root!=0) return false;
        /*然后，有根节点开始进行深度优先搜索或广度优先搜索
         * 将遍历过的节点放入HashSet中，如果被遍历的节点超过一次说明该节点有不止一个父节点
         * 如果被遍历的节点为0则说明该二叉树节点没有完全连通也就是还存在另外一个或多个二叉树或者孤立的节点*/

        //采用深度优先遍历
        Set<Integer> set = new HashSet<>();
        set.add(root);
        Stack<Integer> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            if (leftChild[pop] != -1) {
                stack.push(leftChild[pop]);
                if (!set.contains(leftChild[pop])) {
                    set.add(leftChild[pop]);
                } else {
                    return false;
                }
            }
            if (rightChild[pop] != -1) {
                stack.push(rightChild[pop]);
                if (!set.contains(rightChild[pop])) {
                    set.add(rightChild[pop]);
                } else {
                    return false;
                }
            }

        }

        return  set.size()==n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }