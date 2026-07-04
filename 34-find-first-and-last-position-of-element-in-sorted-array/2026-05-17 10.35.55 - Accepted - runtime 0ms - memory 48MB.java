class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums,target);
        int right = left;

        while(left > 0 && nums[left-1] == target){left--;}
        while(right < nums.length-1 && nums[right+1] == target){right++;}

        return new int[]{left,right};
    }

    public int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target)return mid;

            if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
}