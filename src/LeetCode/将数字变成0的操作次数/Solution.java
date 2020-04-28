package LeetCode.将数字变成0的操作次数;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/2/26 8:25
 */
public class Solution {
    public int numberOfSteps (int num) {
        int step = 0;
        while (num!=0){
            if (num%2==0){
                num = num/2;
                step++;
            }else if (num>0){
              num--;
              step++;
            }
        }
        return step;
    }
}
