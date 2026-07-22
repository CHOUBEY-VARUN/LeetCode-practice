class Solution {
    public int maxProduct(int[] nums) {
        int maxEnd = nums[0];
        int minEnd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int prevMax = maxEnd;
            int prevMin = minEnd;

            maxEnd = Math.max(current,
                    Math.max(prevMax * current, prevMin * current));

            minEnd = Math.min(current,
                    Math.min(prevMax * current, prevMin * current));

            result = Math.max(result,maxEnd);  
        }
        
        return Math.max(result,maxEnd);
    }
}