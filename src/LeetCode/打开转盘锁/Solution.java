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
        queue.add("0000");
        queue.add(null);
        Set<String> seen = new HashSet<>();
        seen.add("0000");
        Set<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        int nums = 0;
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (str == null) {
                nums++;
                if (queue.peek() != null) {
                    queue.add(null);
                }
            } else if (str.equals(target)) {
                return nums;
            } else if (!dead.contains(str)){
                for (int i = 0; i < 4; i++) {
                    for (int d = -1;d < 2;d += 2) {
                        Integer y = (str.charAt(i) - '0' + d + 10) % 10;
                        String newstr = str.substring(0,i) + ("" + y) + str.substring(i + 1);
                        if (!seen.contains(newstr)) {
                            seen.add(newstr);
                            queue.offer(newstr);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
