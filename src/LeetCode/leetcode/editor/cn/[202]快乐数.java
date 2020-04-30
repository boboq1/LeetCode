//编写一个算法来判断一个数 n 是不是快乐数。
//
// 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果 可以变为 1，那么这个数就是快乐数。 
//
// 如果 n 是快乐数就返回 True ；不是，则返回 False 。 
//
// 
//
// 示例： 
//
// 输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
// Related Topics 哈希表 数学

package LeetCode.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //递归调用
       /* public boolean isHappy(int n) {
            Set<Integer> nSet = new HashSet<>();
            nSet.add(n);
            return helper(n,nSet);
        }
        private boolean helper(int n, Set<Integer> nSet) {
            int sum = 0;
            while (n != 0) {
                int res = n % 10;
                sum += res*res;
                n = n / 10;
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
            if (nSet.contains(n)) {
                return false;
            } else {
                nSet.add(n);
            }
            return helper(n,nSet);
        }*/
       //快慢指针
        private int getNext(int n){
            int res = 0;
            int mod = 0;
            while (n!=0){
                mod = n%10;
                res += mod*mod;
                n = n/10;
            }
            return res;
        }
        public boolean isHappy(int n) {
            int slow = n;
            int fast = getNext(n);
            while (fast != 1&& slow != fast){
                slow = getNext(slow);
                fast = getNext(getNext(fast));
            }
            return fast == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}