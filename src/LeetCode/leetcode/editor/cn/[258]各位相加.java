//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。 
//
// 示例: 
//
// 输入: 38
//输出: 2 
//解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
// 
//
// 进阶: 
//你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？ 
// Related Topics 数学

package LeetCode.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

class AddDigits{
      public static void main(String[] args) {

           Solution solution = new AddDigits().new Solution();
           int num = 38;
          System.out.println(solution.addDigits(num));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int addDigits(int num) {
        if (num <10) return num;
        int temp = 0;
        while (num != 0) {

           temp += num%10;
           num = num/10;
        }
        num = temp;
        return addDigits(num);
       /* 数学法：所求为树根数：1 2 3 4 5 6 7 8 9，
        则 return (num-1)%9+1;*/
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }