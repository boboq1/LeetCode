//在 N * N 的网格上，我们放置一些 1 * 1 * 1 的立方体。 
//
// 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。 
//
// 请你返回最终形体的表面积。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：[[2]]
//输出：10
// 
//
// 示例 2： 
//
// 输入：[[1,2],[3,4]]
//输出：34
// 
//
// 示例 3： 
//
// 输入：[[1,0],[0,2]]
//输出：16
// 
//
// 示例 4： 
//
// 输入：[[1,1,1],[1,0,1],[1,1,1]]
//输出：32
// 
//
// 示例 5： 
//
// 输入：[[2,2,2],[2,1,2],[2,2,2]]
//输出：46
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 50 
// 0 <= grid[i][j] <= 50 
// 
// Related Topics 几何 数学

package LeetCode.leetcode.editor.cn;
   class SurfaceAreaOf3dShapes{
      public static void main(String[] args) {
           Solution solution = new SurfaceAreaOf3dShapes().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
              public int surfaceArea(int[][] grid) {

                  int suplus = 0;
                  int num = 0;
                  int temp = 0;
                  for (int i = 0; i < grid.length; i++) {
                      for (int j = 0; j < grid.length; j++) {
                          num += grid[i][j];
                          temp += grid[i][j]>0?grid[i][j]-1:0;
                          suplus += i > 0 ? Math.min(grid[i][j], grid[i - 1][j]) : 0;
                          suplus += j > 0 ? Math.min(grid[i][j], grid[i][j - 1]) : 0;
                      }
                  }
                  return num * 6 - suplus * 2-temp*2;
              }
//leetcode submit region end(Prohibit modification and deletion)
      }

  }