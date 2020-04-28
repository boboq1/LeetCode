package AcWing.数位递增的数;

import java.util.Scanner;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/3/18 10:44
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[]sums = new int[n];
        for (int i = 0; i < sums.length; i++) {
            sums[i] = i+1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (helper(sums[i])) count++;
        }
        System.out.println(count);

    }

    private static boolean helper(int sum) {
        int end = 0;
            while (sum!=0) {
                end = sum%10;
                sum = sum/10;
                if (end < sum%10) return false;
            }
        return true;
    }

}
