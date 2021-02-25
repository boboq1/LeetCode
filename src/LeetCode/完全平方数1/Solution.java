package LeetCode.完全平方数1;

import java.util.*;

/**
 * @Author: hcb
 * @Date: 2021/2/20 21:06
 * @Version 1.0
 */
public class Solution {
       /* public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0] = 0;
            int max_square = (int) Math.sqrt(n) + 1;
            int[] square_array = new int[max_square];
            for (int i = 1; i < max_square; i++) {
                square_array[i] = i * i;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j < max_square; j++) {
                    if (i < square_array[j])break;
                    dp[i] = Math.min(dp[i],dp[i - square_array[j]] + 1);
                }
            }
            return dp[n];
        }*/
       public int numSquares(int n) {
           List<Integer> squareArrays = new LinkedList<>();
           for (int i = 1; i * i <= n; i++) {
               squareArrays.add(i * i);
           }
           Set<Integer> queue = new HashSet<>();
           queue.add(n);
           int high = 0;
           while (queue.size() != 0) {
               high += 1;
               Set<Integer> set = new HashSet<>();
               for (Integer reminder : queue) {
                   for (Integer squareArray : squareArrays) {
                       if (reminder.equals(squareArray)) {
                           return high;
                       } else if (reminder < squareArray) break;
                       else {
                           set.add(reminder - squareArray);
                       }
                   }
               }
               queue = set;
           }
           return high;
       }

      /*  public static void main(String[] args) {
            new Solution().numSquares(12);
        }*/
}
