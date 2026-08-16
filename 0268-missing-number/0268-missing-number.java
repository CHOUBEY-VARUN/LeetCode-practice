class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        int x = nums[0];
        for(int i = 1; i <= nums.length-1; i++){
            result ^= i;
            x ^= nums[i];
        }
        return result^x^nums.length;
    }
}