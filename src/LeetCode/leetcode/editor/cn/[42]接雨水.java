//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针

package LeetCode.leetcode.editor.cn;
   class TrappingRainWater{
      public static void main(String[] args) {
           Solution solution = new TrappingRainWater().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int pre = 0;
        int last = height.length -1;
        int maxLeft = height[0];
        int maxright = height[last];
        int result = 0;
        while (pre < last) {
            if (maxLeft < maxright) {
                pre++;
                maxLeft = Math.max(maxLeft,height[pre]);
                result += maxLeft > height[pre]?maxLeft-height[pre]:0;
            }else {
                last--;
                maxright = Math.max(maxright,height[last]);
                result += maxright > height[last]?maxright-height[last]:0;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }