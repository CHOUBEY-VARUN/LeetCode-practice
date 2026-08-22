class Solution {
    public boolean canJump(int[] nums) {
          int maxReach = nums[0];
          for(int i = 0; i<nums.length; i++){
            if(maxReach >= nums.length-1)return true;
            if(i <= maxReach){
                maxReach = Math.max(maxReach,(i+nums[i]));
            }
          }
          return false;
    }
}