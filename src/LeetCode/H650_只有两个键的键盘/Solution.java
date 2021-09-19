package LeetCode.H650_只有两个键的键盘;

/**
 * @Auther: 13771
 * @Date: 2021/9/19 20:32
 * @Description: Solution
 * @Version 1.0.0
 */
public class Solution {
    public int minSteps(int n) {
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; i++) {//i= 1时只有一个‘A’，操作（复制、粘贴）次数为0，从2开始
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {//当j的平放大于i时，复制的j个'A'不能用于粘贴并计算操作次数，j过大了
                if (i % j == 0) {//若有余数则经过若干操作后不能得到i个‘A',而是有多余的’A‘，所以要按照上次j能整除i的结果作为最终次数
                    f[i] = Math.min(f[i], f[j] + i / j);//复制了j个’A',经过一次复制j个’A'和i/j-1次粘贴 并加上得到j个‘A'的操作次数(f[j])为f[i]的操作次数，与原f[i]比较取最小值
                    f[i] = Math.min(f[i], f[i / j] + j);//f[i/j]表示得到i/j个‘A'进行的操作，经过1次复制i/j个’A'和(j-1)次粘贴得到j次操作，则f[i]为f[i/j]+j与原f[i]比较取最小值
                }
            }
        }
        return f[n];
    }
}
