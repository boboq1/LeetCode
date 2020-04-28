//统计所有小于非负整数 n 的质数的数量。 
//
// 示例: 
//
// 输入: 10
//输出: 4
//解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
// Related Topics 哈希表 数学

package LeetCode.leetcode.editor.cn;
   class CountPrimes{
      public static void main(String[] args) {
           Solution solution = new CountPrimes().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }
    public boolean isPrime(int n) {

        int num = (int) Math.sqrt(n);
        for (int i = 2; i < num; i++) {
            if (n%i==0) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }