//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划

package LeetCode.leetcode.editor.cn;

import java.util.Arrays;

class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {//4.20 20:00
        //方法一：动态规划
    /*public int lengthOfLIS(int[] nums) {

        if (len == 0) return 0;
        int len = nums.length;
        int[] result = new int[len];
        result[0] = 1;
        for (int i = 1; i < len; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max,result[j]);
                }
            }
            result[i] = max + 1;
        }

        Arrays.sort(result);
        return result[result.length-1];
    }*/
        /*//贪心算法+二分查找
        public int lengthOfLIS(int[] nums) {
            if (len == 0) return 0;
            int[] sortNums = new int[len];
            int res = 0;
            for (int num : nums) {
                int i = 0, j = res;
                while (i < j) {
                    int mid = (i + j) / 2;
                    if (sortNums[mid] < num) i = mid + 1;
                    else j = mid;
                }
                sortNums[i] = num;
                if (res == j) res++;
            }
            return res;
        }*/


         //贪心算法
        public int lengthOfLIS(int[] nums) {
            int len = nums.length;
            if (len == 0) return 0;
            int[]arrays = new int[len];
            int res = 0;
            for (int num : nums) {
                int i = 0,j = res;
                while (i<j){
                    int mid = (i+j)/2;
                    if (arrays[mid]<num) i = mid + 1;
                    else j = mid;
                }
                arrays[i] = num;
                if (res == j) res++;
            }
            return res;
        }

























    }
//leetcode submit region end(Prohibit modification and deletion)

}