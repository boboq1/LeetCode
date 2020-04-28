package AcWing.AplusB;

import java.util.Scanner;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/2/26 9:52
 */
public class Main {

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()){
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            if (A>=0&&A<Math.pow(10,8)&&B>=0&&B<Math.pow(10,8))
            System.out.println(A+B);
        }

    }
}
