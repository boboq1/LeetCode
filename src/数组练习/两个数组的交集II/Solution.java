package 数组练习.两个数组的交集II;

import java.util.*;

public class Solution {

   /* public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] nums3 = {};
        if (length1 == 0 || length2 == 0) return nums3;
        List<Integer> list = new ArrayList<>();
            for (int j = 0,i = 0; j < length2 && i < length1; ) {
                if (nums1[i] == nums2[j]){
                    list.add(nums1[i]);
                    i++;j++;
                }else if (nums1[i] < nums2[j]) {
                    i++;
                } else{
                    j++;
                }
                if (i >= length1 || j >= length2) break;
            }
        nums3 = new int[list.size()];
        for (int i = 0; i < nums3.length; i++) {
            nums3[i] = list.get(i);
        }
        return nums3;

    }
    public static void main(String[] args) {
       int[] nums1 = {43,85,49,2,83,2,39,99,15,70,39,27,71,3,88,5,19,5,68,34,7,41,84,2,13,85,12,54,7,9,13,19,92},
             nums2 = {10,8,53,63,58,83,26,10,58,3,61,56,55,38,81,29,69,55,86,23,91,44,9,98,41,48,41,16,42,72,6,4,2,81,42,84,4,13};
       int[] array = new Solution().intersect(nums1, nums2);
        for (int i : array) {
            System.out.println(i);
        }
    }*/
   public int[] intersect(int[] nums1, int[] nums2) {
       if (nums1 == null || nums2 == null) return null;
       int length1 = nums1.length;
       int length2 = nums2.length;
       int[] nums3 = {};
       if (length1 == 0 || length2 == 0) return nums3;
       Map<Integer,Integer> map = new HashMap<>();
       nums3 = new int[length1]; //改进后
       int index = 0;
       for (int num : nums1) {
           if (map.keySet().contains(num)){
               int count = map.getOrDefault(num,0) + 1;
               map.put(num,count);
           }
           else {
               map.put(num,1);
           }
       }
//       ArrayList<Integer> list = new ArrayList<>();//改进前
       for (int i = 0; i < length2; i++) {
           if (map.keySet().contains(nums2[i]) && map.get(nums2[i]) > 0){
               int count = map.get(nums2[i]) - 1;
               map.put(nums2[i],count);
//               list.add(nums2[i]);
               nums3[index++] = nums2[i];
           }
       }

       //改进前
     /*  nums3 = new int[list.size()];
       for (int i = 0; i < nums3.length; i++) {
           nums3[i] = list.get(i);
       }*/
       return Arrays.copyOfRange(nums3,0,index);
   }

}
