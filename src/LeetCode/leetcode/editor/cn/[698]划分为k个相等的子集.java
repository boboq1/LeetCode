//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 
//
// 注意: 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 
// Related Topics 递归 动态规划

package LeetCode.leetcode.editor.cn;

import java.util.Arrays;

class PartitionToKEqualSumSubsets{
      public static void main(String[] args) {
           Solution solution = new PartitionToKEqualSumSubsets().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          /*
          * 使用的是递归+回溯*/
    public boolean canPartitionKSubsets(int[] nums, int k) {

        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max,nums[i]);
        }
        if (sum%k !=0 || max > sum/k) return false;
        boolean[] used = new boolean[nums.length];
        return helper(nums,k,sum/k,0,0,used);
    }

    private boolean helper(int[] nums, int k, int target, int cur, int start, boolean[] used) {
        if (k == 0) return true;
        if (target == cur) {
            return helper(nums,k-1,target,0,0,used);
        }
        /*
        * 回溯法： 在包含问题的所有解的解空间树中，按照深度优先搜索的策略，从根结点出发深度探索解空间树。当探索到某一结点时，要先判断该结点是否包含问题的解，如果包含，就从该结点出发继续探索下去，如果该结点不包含问题的解，则逐层向其祖先结点回溯。（其实回溯法就是对隐式图的深度优先搜索算法）。

       若用回溯法求问题的所有解时，要回溯到根，且根结点的所有可行的子树都要已被搜索遍才结束。

       而若使用回溯法求任一个解时，只要搜索到问题的一个解就可以结束。*/
        for (int i = start; i < nums.length; i++) {
            if (!used[i]&&cur+nums[i]<=target) {
                used[i] = true;
                if (helper(nums,k,target,cur+nums[i],i+1,used)) return true;
                used[i] = false;
            }
        }
        return false;
    }

      }
//leetcode submit region end(Prohibit modification and deletion)

  }