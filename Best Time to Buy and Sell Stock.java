public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) { return 0; }
        
        int min = prices[0], profit = 0;
        
        for(int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            if(prices[i] - min > profit) {
                profit = prices[i] - min;
            }
        }
        return profit;
    }
}
