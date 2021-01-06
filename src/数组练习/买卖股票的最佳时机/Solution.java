package 数组练习.买卖股票的最佳时机;

public class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int profit = 0;
        for (int j = 1; j < prices.length; j++){
            if (prices[i] >= prices[j] && i < j)i++;
            else {
                profit += prices[j] - prices[i];
                i = j;
            }
        }
        return profit;
    }
}
