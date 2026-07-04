class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currSum = 0;
        int maxSum = 0;
        for(int n : nums){
            if(currSum + n > n){
                currSum += n;
                maxSum = Math.max(maxSum,currSum);
            }else{
                currSum = n;
                maxSum = Math.max(maxSum,currSum);
            }
        }

        currSum = 0;
        int minSum = 0;
        for(int n : nums){
            if(currSum + n < n){
                currSum +=n;
                minSum = Math.min(minSum,currSum);
            }else{
                currSum = n;
                minSum = Math.min(minSum,currSum);
            }
        }

        return Math.max(Math.abs(minSum),maxSum);
    }
}