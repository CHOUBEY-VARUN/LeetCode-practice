class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int ans = 1;

        for(int right = 0; right<nums.length; right++){
            for(int left = 0; left<right; left++){
                if(nums[left] < nums[right]){
                    dp[right] = Math.max(dp[left]+1 , dp[right]);
                    ans = Math.max(ans,dp[right]);
                }
            }
        }
        return ans;
    }
}