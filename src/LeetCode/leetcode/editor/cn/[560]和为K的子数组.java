
//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表

package LeetCode.leetcode.editor.cn;
import	java.util.HashMap;
   class SubarraySumEqualsK{
      public static void main(String[] args) {
           Solution solution = new SubarraySumEqualsK().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {

      /*  if (nums == null || nums.length == 0 ) return 0;
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j >= 0; --j) {
                sum += nums[j];
                if (sum == k) ans++;
            }
        }
        return ans;*/
      int ans = 0,pre = 0;
      HashMap<Integer, Integer> map = new HashMap<> ();
      map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k))
                ans += map.get(pre - k);
            map.put(pre,map.getOrDefault(pre,0) + 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }