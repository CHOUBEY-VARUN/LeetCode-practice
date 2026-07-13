class Solution {
    public int fib(int n) {
        if(n<=1)return n;
        int[] seq = new int[n+1];
        seq[0] = 0;
        seq[1] = 1;
        for(int i = 2; i<=n; i++){
            seq[i] = seq[i-1]+seq[i-2];
        }

        return seq[n];
    }
}