class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int m = Integer.MAX_VALUE;
        int[] min = new int[nums.length];
        for(int n = min.length-1; n>=0; n--){
            m = Math.min(m,nums[n]);
            min[n] = m;
        }
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<nums.length; i++){
            max = Math.max(max,nums[i]);
            int score = max - min[i];
            if(score <= k){
                return i;
            }else{continue;}
        }
        return -1;
    }
}