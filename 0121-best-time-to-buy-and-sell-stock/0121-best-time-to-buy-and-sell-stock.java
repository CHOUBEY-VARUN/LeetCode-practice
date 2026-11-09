class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;

        for(int n : prices){
            if(n < buy){
                buy = n;
            }
            profit = Math.max(profit,n-buy);
        }
        return profit;
    }
}