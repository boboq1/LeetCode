package LeetCode.爬楼梯;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/3/8 8:49
 */
public class Solution {
//    public int climbStairs(int n) {
//        int[] m = new int[n+1];
//        return climbStairs1(0,n,m);
//    }
//    public int climbStairs1(int i,int n,int[] m) {
//        if (i>n) return 0;
//        if (i==n) return 1;
//        if (m[i] > 0) return m[i];
//        m[i] = climbStairs1(i+1,n,m) + climbStairs1(i+2,n,m);
//        return m[i];
//    }
     /* public int climbStairs(int n) {

          if (n <= 1) return 1;
          int[] m = new int[n+1];
          m[0] = 1;
          m[1] = 1;
          for (int i = 2; i <= n; i++) {
              m[i] = m[i-1] + m[i-2];
          }
          return m[n];
      }*/
     public int climbStairs(int n) {

         if (n <= 1) return 1;
         int temp = 0;
         int last = 1;
         int cur  = 1;
         for (int i = 2; i <= n; i++) {
            temp = last + cur;
            last = cur;
            cur = temp;
         }
         return cur;
     }
}
