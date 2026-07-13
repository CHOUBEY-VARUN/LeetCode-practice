class Solution {
    public int fib(int n) {
        Map<Integer,Integer> memo = new HashMap<>();
        return result(n,memo);
    }

    public int result(int n, Map<Integer,Integer> memo){
        if(n<=1)return n;

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        int ans = result(n-1,memo) + result(n-2,memo);
        memo.put(n,ans);
        return ans;
    }
}