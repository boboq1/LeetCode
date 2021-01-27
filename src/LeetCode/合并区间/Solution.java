package LeetCode.合并区间;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });
       /* List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < left) {
                merged.add(intervals[i]);
            }else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1],right);
            }
        }
        return merged.toArray(new int[merged.size()][]);*/
        int temp = 0;
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length;) {
            temp = intervals[i][1];
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] < temp) {
                temp = Math.max(temp,intervals[j][1]);
                j++;
            }
            merged.add(new int[]{intervals[i][0],temp});
            i = j;
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
