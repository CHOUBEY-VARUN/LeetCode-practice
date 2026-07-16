class Solution {
    public int maxProduct(int[] nums) {
        int maxEnd = nums[0];
        int minEnd = nums[0];
        int result = nums[0];

        for(int i = 1; i<nums.length; i++){
            int current = nums[i];
            int maxPrev = maxEnd;
            int minPrev = minEnd;
            
            maxEnd = Math.max(
                current, Math.max(
                    maxPrev*current, minPrev*current
                )
            );

            minEnd = Math.min(
                current, Math.min(
                    maxPrev*current, minPrev*current
                )
            );

            result = Math.max(result,maxEnd);
        }
        return result;
    }
}