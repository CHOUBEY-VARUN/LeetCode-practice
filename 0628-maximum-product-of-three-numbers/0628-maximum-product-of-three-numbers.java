class Solution {
    public int maximumProduct(int[] nums) {
        int XXL = Integer.MIN_VALUE;
        int XL = Integer.MIN_VALUE;
        int L = Integer.MIN_VALUE;

        int XS = Integer.MAX_VALUE;
        int S = Integer.MAX_VALUE;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] < XS){
                S = XS;
                XS = nums[i];
            }else if(nums[i] < S){
                S = nums[i];
            }

            if(nums[i] > XXL){
                L = XL;
                XL = XXL;
                XXL = nums[i];
            }else if(nums[i] > XL){
                L = XL;
                XL = nums[i];
            }else if(nums[i] > L){
                L = nums[i];
            }else{continue;}
        }

        return Math.max((XXL*XL*L),(XS*S*XXL));
    }
}