package LeetCode.通知所有员工所需的时间;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/3/8 11:22
 */
public class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        int time = 0;
        Set<Integer> set = new HashSet<>();
        int min = 0;
        for (int i = 0; i < manager.length; i++) {

        }
        return time;
       /*int sum = 0;
        for (int i = 0; i < informTime.length; i++) {
            if (informTime[i] == 0) {
                int time = 0;
                int index = i;
                while (index!=-1) {
                    time += informTime[index];
                    index = manager[index];
                }
                sum = Math.max(time,sum);
            }
        }
       return sum;
*/

    }
}
