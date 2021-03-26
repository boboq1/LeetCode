package LeetCode.打开转盘锁;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: hcb
 * @Date: 2021/2/24 20:36
 * @Version 1.0
 */
public class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        queue.add("0000");
        queue.add(null);
        Set<String> seen = new HashSet<>();
        seen.add("0000");
        int res = 0;
        while (queue.size() != 0) {
           String node = queue.poll();
           if (node == null) {
               res++;
               if (queue.peek() != null) {
                   queue.add(null);
               }
           } else if (node.equals(target)) {
               return res;
           } else if (!dead.contains(node)) {
               for (int i = 0; i < 4; i++) {
                   for (int d = -1;d < 2;d += 2) {
                       Integer y = (node.charAt(i) - '0' + d + 10) % 10;
                       String temp = node.substring(0,i) + ("" + y) + node.substring(i + 1);
                       if (!seen.contains(temp)){
                           seen.add(temp);
                           queue.offer(temp);
                       }
                   }
               }
           }
        }
        return -1;
    }
}
