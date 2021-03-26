package 数组练习.只出现一次的数字;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
   /* public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Map<Integer,Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i])) {
                map.put(nums[i],true);
            }else
            map.put(nums[i],false);
        }
        for (Map.Entry<Integer,Boolean> entry:map.entrySet()){
            if (entry.getValue())return entry.getKey();
        }
        return 0;
    }*/
   public int singleNumber(int[] nums) {
       int singleNumber = 0;
       for (int num : nums) {
           singleNumber ^= num;
       }
       String str = "";
       Set<Integer> set = new HashSet<>();
       return singleNumber;
   }
}
