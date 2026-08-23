class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums,target,true);
        if(left == -1)return new int[]{-1,-1};
        int right = binarySearch(nums,target,false);
        return new int[]{left,right};
    }

    public int binarySearch(int[] nums, int target, boolean lefty){
        int left = 0;
        int right = nums.length - 1;
        int x = -1;

        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                x = mid;
                if(lefty){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return x;
    }
}
