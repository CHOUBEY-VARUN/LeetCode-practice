class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int buy = 0;
        for(int sell = 0; sell<prices.length; sell++){
            if(prices[sell] < prices[buy]){
                buy = sell;
            }
            int profit = prices[sell] - prices[buy];
            maxProfit = Math.max(profit,maxProfit);
        }
        return maxProfit;
    }
}