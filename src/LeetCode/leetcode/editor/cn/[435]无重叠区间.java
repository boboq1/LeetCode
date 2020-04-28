//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。 
//
// 注意: 
//
// 
// 可以认为区间的终点总是大于它的起点。 
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 
// 
//
// 示例 1: 
//
// 
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
// Related Topics 贪心算法

package LeetCode.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

class NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals().new Solution();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {-100, -2}, {5, 7}};
        solution.eraseOverlapIntervals(intervals);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //从前往后的贪心算法
    /*public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length==0 || intervals == null) return 0;
        Arrays.sort(intervals,( o1,  o2)-> o1[0]-o2[0]==0?o1[1]-o2[1]:o1[0]-o2[0]);

        int [] a = new int[2];
        int counter = 0;
        a = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (a[1]>intervals[i][0]&&a[1]>=intervals[i][1]){
                counter++;
                a=intervals[i];
            }else if (a[1]>intervals[i][0]&&a[1]<intervals[i][1]) {
                counter++;
            }else if (a[1]<=intervals[i][0]){
                a = intervals[i];
            }
        }
        return counter;
    }*/
        //从后往前的贪心算法
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0 || intervals == null) return 0;
            Arrays.sort(intervals, ((o1, o2) -> o1[1] - o2[1]));
            int pre = 0;
            int count = 1;
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] >= intervals[pre][1]) {
                    count++;
                    pre = i;
                }
            }
            return intervals.length - count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}