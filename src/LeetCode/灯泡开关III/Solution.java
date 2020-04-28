package LeetCode.灯泡开关III;

import java.util.*;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/3/8 11:03
 */
public class Solution {
    public int numTimesAllBlue(int[] light) {

        int time = 0;
        int max = 0;
        int num = 0;
        while (time<light.length) {
            max = Math.max(max,light[time]);
            if (max == time + 1) {
                num++;
            }
            time++;
        }
        return num;
    }
}
