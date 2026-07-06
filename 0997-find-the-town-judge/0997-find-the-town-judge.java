class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] trustedBy = new int[n+1];
        int [] trustsOthers = new int[n+1];

        for(int[] edge : trust){
            int u = edge[0];
            int v = edge[1];

            trustsOthers[u]++;
            trustedBy[v]++;
        }

        for(int i = 1; i <= n; i++){
            if(trustsOthers[i] == 0 && trustedBy[i] == n-1)return i;
        }

        return -1;
    }
}