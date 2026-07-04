class Solution {
    public int missingNumber(int[] nums) {
        int add = 0;
        for(int i = 0; i<=nums.length; i++){
            add += i;
        }
        for(int i = 0; i<nums.length; i++){
            add -= nums[i];
        }
        return add;
    }
}