class Solution {
    public int maxProduct(int[] nums) {
        int prevMax = nums[0];
        int prevMin = nums[0];
        int max = nums[0];

        for(int i = 1; i<nums.length; i++){
            int current = nums[i];
            int currMax = prevMax;
            int currMin = prevMin;

            prevMax = Math.max(
                current,
                Math.max(currMax*current,currMin*current)
            );
            prevMin = Math.min(
                current,
                Math.min(currMax*current,currMin*current)
            );
            max = Math.max(max,prevMax);
        }
        return max;
    }
}