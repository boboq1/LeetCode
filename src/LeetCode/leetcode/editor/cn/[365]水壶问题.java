//有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？ 
//
// 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。 
//
// 你允许： 
//
// 
// 装满任意一个水壶 
// 清空任意一个水壶 
// 从一个水壶向另外一个水壶倒水，直到装满或者倒空 
// 
//
// 示例 1: (From the famous "Die Hard" example) 
//
// 输入: x = 3, y = 5, z = 4
//输出: True
// 
//
// 示例 2: 
//
// 输入: x = 2, y = 6, z = 5
//输出: False
// 
// Related Topics 数学

package LeetCode.leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class WaterAndJugProblem {
    public static void main(String[] args) {
        Solution solution = new WaterAndJugProblem().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //z = a*x + b*y, x,y的最大公约数是z的整数倍
    /*public boolean canMeasureWater(int x, int y, int z) {
        return z == 0 || (x + y >=z && z % gcd(x,y) == 0);
    }
    int gcd(int x,int y) {
        return y==0?x:gcd(y,x%y);
    }*/
    //dfs
        public boolean canMeasureWater(int x, int y, int z) {
              if (z < 0 || x+y < z) return false;
              Set<Integer> set = new HashSet<>();
              Queue<Integer> queue = new LinkedList<>();
              ((LinkedList<Integer>) queue).add(0);
              while (!queue.isEmpty()) {
                  int n = queue.poll();
                  if (n + x <= x+y && set.add(n+x)) {
                      queue.offer(n+x);
                  }
                  if (n + y <= x+y && set.add(n+y)) {
                      queue.offer(n+y);
                  }
                  if (n - x >= 0 && set.add(n-x)) {
                      queue.offer(n-x);
                  }
                  if (n - y >= 0 && set.add(n - y)) {
                      queue.offer(n-y);
                  }
                  if (set.contains(z)) return true;

              }
              return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}