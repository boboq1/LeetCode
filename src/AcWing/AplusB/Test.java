package AcWing.AplusB;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/3/19 10:19
 */
public class Test {
    public void Demo_int(int[] sums) {

        Arrays.sort(sums);
        System.out.println("默认升序：");
        for (int sum : sums) {
            System.out.print(sum+" ");
        }
        int[][] nums = new int[sums.length][1];
        for (int i = 0; i < nums.length; i++) {
            nums[i][0] = sums[i];
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        System.out.println("\n降序：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i][0]+" ");
        }
    }
    private void Demo_Integer(Integer[] sums) {
        Arrays.sort(sums);
        System.out.println("\n默认升序：");
        for (Integer sum : sums) {
            System.out.print(sum+" ");
        }
        Arrays.sort(sums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println("\n降序排列：");
        for (Integer sum : sums) {
            System.out.print(sum+" ");
        }
    }

    public static void main(String[] args) {
        int[] sums = {4,23,6,3,4,12,75,123};
        Integer[] sums1 = {4,23,6,3,4,12,75,34,3};
       Test test = new Test();
       test.Demo_int(sums);
       test.Demo_Integer(sums1);


    }
}
