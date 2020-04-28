package LeetCode.最多可以参加的会议数目;

import java.util.*;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/2/16 11:39
 * method 贪心算法
 */
public class Solution {

    public int maxEvents(int[][] events) {
        int result=0;
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        Set<Integer> set = new HashSet<>();
        for (int[]event:events){
            int j = event[1];
            for (int i=event[0];i<=j;i++){
               if (!set.contains(i)){
                   set.add(i);
                   break;
               }

            }
        }
        return set.size();
    }
}
