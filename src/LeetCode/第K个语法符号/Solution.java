package LeetCode.第K个语法符号;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/3/17 23:18
 */
public class Solution {
    public int kthGrammar(int N, int K) {
        int[] temp = new int[1<<N-1];
        for (int i = 1;i < N;i++) {
            for (int j = 1<<i-1; j >=1 ; ++j) {
                temp[2*j] = temp[j];
                temp[2*j+1] = 1 - temp[2*j];
            }
        }
        return temp[K-1];
    }
}
