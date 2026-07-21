class Solution {
    public int coinChange(int[] coins, int amount) {
        return numCoins(coins,amount,new HashMap<>());
    }

    public int numCoins(int[] coins, int amount, Map<Integer,Integer> memo){
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(memo.containsKey(amount)) return memo.get(amount);

        int min = Integer.MAX_VALUE;
        
        for(int coin : coins){
            int result = numCoins(coins,amount-coin,memo);
            if(result >= 0) min = Math.min(min,result+1);
        }

        int ans = min == Integer.MAX_VALUE? -1 : min;
        memo.put(amount,ans);
        return ans;
    }
}