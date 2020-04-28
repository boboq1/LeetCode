//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组

package LeetCode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class MergeIntervals{
      public static void main(String[] args) {
           Solution solution = new MergeIntervals().new Solution();
           int[][]intervals = {{8,10},{15,18},{1,3},{2,6}};
           solution.merge(intervals);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
   /* public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[][] res = new int[intervals.length][2];
        int index = -1;
//        List<int[][]> lists = new ArrayList<>();
        for (int interval[] : intervals) {
         if (index == -1 || interval[0] > res[index][1]){
             res[++index] = interval;
         }else {
             res[index][1] = Math.max(res[index][1],interval[1]);
         }
        }
        return Arrays.copyOf(res,index+1);
    }*/
   public int[][] merge(int[][] intervals) {
       int len = intervals.length;
       if (len<=1) return intervals;
       Arrays.sort(intervals, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               return o1[0]-o2[0];
           }
       });
       List<int[]> lists = new ArrayList<>();
       lists.add(intervals[0]);
       for (int i = 1; i < len; i++) {
           int[] temp = lists.get(lists.size()-1);//peek 是对象，表示的是一个内存地址，通过内存地址修改里面的值是可以的。
           if (temp[1]<intervals[i][0]){
               lists.add(intervals[i]);
           }else {
               temp[1] = Math.max(temp[1],intervals[i][1]);
           }
       }

       return lists.toArray(new int[lists.size()][]);
   }
}
//leetcode submit region end(Prohibit modification and deletion)

  }