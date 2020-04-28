package AcWing.递增三元组的中心;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/3/18 10:14
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sums = new int[n+1];
        for (int i = 0; i < sums.length; i++) {
            if (i!=0) sums[i] = scanner.nextInt();
        }
        int count = 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 2; i <= n-1; i++) {
            min = Math.min(min,sums[i-1]);
            int t = i + 1;
            while (t<=n) {
                max = Math.max(max,sums[t++]);
            }
            if (sums[i]>min&&sums[i] < max) count++;
        }
        System.out.println(count);
    }
}
