class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int zeroes = 0;
        for(int num : nums){
            if(num != 0){prod *= num;}else{zeroes++;}
        }
        
        if(zeroes>1){return new int[nums.length];}
        int[] result = new int[nums.length];
        if(zeroes == 1){
            for(int i = 0; i<nums.length; i++){
                if(nums[i] == 0){
                    result[i] = prod;
                }else{
                    nums[i] = 0;
                }
            }
        }else{
            for(int i = 0; i<nums.length; i++){
                result[i] = prod/nums[i];
            }
        }
        return result;
    }
}