class Solution {
    public int maxSubArray(int[] nums) {
        int count = nums[0];
        int currSum = nums[0];
        int maxSum = nums[0];
        
        for(int i = 1; i<nums.length; i++){
            if((currSum + nums[i]) >= nums[i] ){
                count++;
                currSum += nums[i];
                maxSum = maxSum >= currSum ? maxSum : currSum; 
            }else{
                count = 1;
                currSum = nums[i];
                maxSum = maxSum >= currSum ? maxSum : currSum;
            }
        }
        return maxSum;
    }
}