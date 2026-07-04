class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                product *= nums[i];
            } else if (nums[i] == 0) {
                zeroes++;
            }
        }

        int[] res = new int[nums.length];
        for (int n = 0; n < nums.length; n++) {
            if(zeroes == 1){
                if(nums[n] == 0){
                    res[n] = product;
                }else{
                    res[n] = 0;
                }
            }else if(zeroes == 0){
                res[n] = product/nums[n];
            }else{
                res[n] = 0;
            }
        }
        return res;
    }
}