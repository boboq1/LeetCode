//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划

package LeetCode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class ClimbingStairs{
      public static void main(String[] args) {
           Solution solution = new ClimbingStairs().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

          //1有暂存功能的递归调用
   /* public int climbStairs(int n) {

        int[] m = new int[n+1];
        return climbStairs(0,n,m);
    }
    public int climbStairs(int i,int n,int[] m) {
        if (i>n) return 0;
        if (i == n) return 1;
        if (m[i] > 0) return m[i];
        m[i] = climbStairs(i+1,n,m) + climbStairs(i+2,n,m);
        return m[i];
    }*/
   //2动态规划
   /*public int climbStairs(int n) {
       if (n==1) return 1;
       if (n==0) return 1;
       int[] m = new int[n+1];
       m[1] = 1;
       m[0] = 1;
       for (int i = 2; i <m.length; i++) {
            m[i] = m[i-2] + m[i-1];
       }
       return m[n];
   }*/
   //2斐波那契
    public int climbStairs(int n) {

        if (n == 1) return 1;
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }