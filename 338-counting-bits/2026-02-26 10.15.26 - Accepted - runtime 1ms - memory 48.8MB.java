class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i = 0; i<=n ; i++){
            int cur = i;
            int temp = 0;
            while(cur != 0){
                cur = (cur - 1) & cur;
                temp++;
            }
            result[i] = temp;
        }
        return result;
    }
}