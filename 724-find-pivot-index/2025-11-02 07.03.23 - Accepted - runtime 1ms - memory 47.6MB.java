class Solution {
    public int pivotIndex(int[] nums) {
        int h1 = 0;
        int h2  = 0;
        for(int i = 1;i<nums.length;i++){h2+=nums[i];}
        for(int i = 0; i<nums.length; i++){
            if(h1 == h2){return i;}
            h1 += nums[i];
            if(nums.length > i+1){h2 -= nums[i+1];}else{h2=0;}
        }
        return -1;
    }
}