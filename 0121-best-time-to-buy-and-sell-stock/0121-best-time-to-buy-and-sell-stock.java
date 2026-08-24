class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = prices[0];
        int maxProfit = sell - buy;

        for(int i = 1; i<prices.length; i++){
            buy = Math.min(buy,prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - buy);
        }
        return maxProfit;
    }
}