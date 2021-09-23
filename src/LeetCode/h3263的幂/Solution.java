package LeetCode.h3263的幂;

/**
 * @Auther: 13771
 * @Date: 2021/9/23 21:31
 * @Description: Solution
 * @Version 1.0.0
 */
public class Solution {
//    public static void main(String[] args) {
//        System.out.print(new Solution().isPowerOfThree(27));
//    }

    /*public boolean isPowerOfThree(int n) {
        while (n > 1) {
            if (n % 3 == 0) {
                n /= 3;
            } else return false;
        }
        if (n == 1) return true;
        else return false;
    }*/
    //二分法,效果差,要进行越界处理(3的n次方可能超出Integer最大值)
    /*public boolean isPowerOfThree(int n) {
        int b = n / 2;
        int a = 0;
        while (a < b) {
            int media = (b - a) / 2 + a;
            if ((int) Math.pow(3, media) == n) {
                return true;
            } else if ((int) Math.pow(3, media) < n) {
                a = media + 1;
            } else {
                b = media - 1;
            }
        }
        return (int) Math.pow(3, a) == n;
    }*/
    //法三
//    public boolean isPowerOfThree(int n) {
//        int
//    }
}
