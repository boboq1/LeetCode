package LeetCode.买卖股票的最佳时机;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/2/21 13:41
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null){
            return 0;
        }
        int length=0;
        for (int i=0;i<prices.length-1;i++){
            int sum = prices[i]-prices[i+1];
            if (sum>0){
                length += sum;
            }
        }
        return length;
    }
}
