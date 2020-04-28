//泰波那契序列 Tn 定义如下： 
//
// T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
//
// 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。 
//
// 
//
// 示例 1：
//
// 输入：n = 4
//输出：4
//解释：
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
// 
//
// 示例 2： 
//
// 输入：n = 25
//输出：1389537
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 37 
// 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
// 
// Related Topics 递归

package LeetCode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class NThTribonacciNumber{
      public static void main(String[] args) {
           Solution solution = new NThTribonacciNumber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          //方法一：存储中间结果+递归调用
   /* public int tribonacci(int n) {

        int[] temp = new int[n+1];
        return helper(n,temp);
    }
    public int helper(int n,int[] temp) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        temp[0] = 0;
        temp[1] = 1;
        temp[2] = 1;
        if (temp[n]>0) return temp[n];
        for (int i = 3; i < n+1; i++) {
            temp[i] = helper(i-1,temp) + helper(i-2,temp) + helper(i-3,temp);
        }

        return temp[n];
    }*/
   //方法二：Map<Integet,Integer>
    public int tribonacci(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        return helper(n,map);
    }

  private int helper(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        map.put(0,0);
        map.put(1,1);
        map.put(2,1);
        int val1 = helper(n-1,map);
        int val2 = helper(n-2,map);
        int val3 = helper(n-3,map);
        map.put(n,val1+val2+val3);
        return val1 + val2 + val3;
  }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }