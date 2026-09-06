class Solution {
    public int removeDuplicates(int[] nums) {
        int unique = 1;
        int left = 0;
        for(int right = 1; right<nums.length; right++){
            if(nums[left] != nums[right]){
                unique++;
                nums[left+1] = nums[right];
                left++;
            }
        }
        return unique;
    }
}