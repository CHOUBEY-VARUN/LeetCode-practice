class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxProduct(int[] nums) {
        search(nums,0);
        return max;
    }

    public void search(int[] nums,int left){
        if(left == nums.length-1) max = Math.max(max,nums[left]);
        if(left>nums.length -1) return;

        int prod = 1;
        for(int i = left; i<nums.length; i++){
            prod = prod*nums[i];
            max = Math.max(max,prod);
        }

        search(nums,left+1);
    }
}