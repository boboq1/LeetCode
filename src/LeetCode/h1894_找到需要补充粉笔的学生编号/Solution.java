package LeetCode.h1894_找到需要补充粉笔的学生编号;

/**
 * @Auther: 13771
 * @Date: 2021/9/10 21:32
 * @Description: Solution
 * @Version 1.0.0
 */
public class Solution {
    //第一次尝试 超市。。。。
   /* public int chalkReplacer(int[] chalk, int k) {
        int length = chalk.length;
        int i = 0;
        while (i < length) {
            if (chalk[i] > k) return i;
            k -= chalk[i];
            i++;
            i = i == length ? 0 : i;
        }
        return 0;
    }*/
    //法二成功
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;//使用64位的long，32位的int可能会溢出
        int length = chalk.length;
        for (int i : chalk) {
            sum += i;
        }
        if (k <= sum) {
            for (int i = 0; i < length; i++) {
                if (k < chalk[i]) return i;
                k -= chalk[i];
            }
            return 0;
        }
        k = (int) (k % sum);
        for (int i = 0; i < length; i++) {
            if (k < chalk[i]) return i;
            k -= chalk[i];
        }
        return 0;
    }
}
