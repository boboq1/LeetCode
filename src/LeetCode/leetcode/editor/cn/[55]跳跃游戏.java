//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组

package LeetCode.leetcode.editor.cn;
   class JumpGame{
      public static void main(String[] args) {
           Solution solution = new JumpGame().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {

        //一
       /* if (nums.length<=1 || nums == null) return true;
        int cur = nums.length-1;
        int i = nums.length-2;
            while (i>=0){
                if (i>=0&&cur - i>nums[i]){
                    if(i == 0) return false;
                    i--;
                }else {
                    cur = i--;
                }
            }*/
       //二
        if (nums.length<=1 || nums == null) return true;
        int rightMax = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i<=rightMax){
                rightMax = Math.max(rightMax,i+nums[i]);
                if(rightMax>=n-1) return true;
            }

        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }