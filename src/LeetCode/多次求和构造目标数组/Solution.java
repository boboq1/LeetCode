package LeetCode.多次求和构造目标数组;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/2/21 11:07
 */
public class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue pq = new PriorityQueue(Collections.reverseOrder());
        int sum = 0;
        for (int a:target){
            pq.add(a);
            sum += a;
        }
        while (true){
            int poll = (int) pq.poll();
            int rest = sum - poll;
            int pre = poll - rest;
            if (pre==poll||pre<1){
                return false;
            }
            pq.offer(pre);
            sum = poll;
            if (sum==target.length){
                return true;
            }
        }

    }
}
