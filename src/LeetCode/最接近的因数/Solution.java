package LeetCode.最接近的因数;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/2/25 10:50
 */
public class Solution {
    public int[] closestDivisors(int num) {

        int[] sum = new int[2];
        int sqrt0 = (int) Math.sqrt(num+1);
        int sqrt1 = (int) Math.sqrt(num+2);
        int[] num1 = calcute(sqrt0,num+1);
        int[] num2 = calcute(sqrt1,num+2);

        return Math.abs(num1[0]-num1[1])>Math.abs(num2[0]-num2[1])?num2:num1;
    }
    private int[] calcute(int sqrt,int num){
        int[]min = new int[2];
        int state = num-1;
        for (int i=1;i<=sqrt;i++){
            if (num%i==0){
                state = Math.min(state,Math.abs(num/i-i));
            }
            if (state==Math.abs(num/i-i)){
                min[0]=i;min[1]=num/i;
            }
        }
        return min;
    }
}
