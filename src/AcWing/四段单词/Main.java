package AcWing.四段单词;

import java.util.Scanner;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/3/18 11:22
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  strs = scanner.next();
        int count = 0;
        for (int i = 0; i < strs.length();) {
            if (helper(strs.charAt(i))&& i==0) {
                break;
            }
            while (i<strs.length()&&!helper(strs.charAt(i))) {
                i++;
            }
                count++;
            while (i<strs.length()&&helper(strs.charAt(i))) {
                i++;
            }
                count++;
        }
        if (count!=4) {
            System.out.println("no");
        }else  System.out.println("yes");
    }

    private static boolean helper(char charAt) {
        switch (charAt){
            case 'a':
                return true;
            case 'e':
                return true;

            case 'i':
                return true;

            case 'o':
                return true;

            case 'u':
                return true;
        }
        return false;
    }
}
