class Solution {
    public int trap(int[] height) {
     int left = 0;
     int leftMax = height[0];
     int right = height.length - 1;   
     int rightMax = height[height.length - 1];   
     int result = 0;

     while(left < right){
        if(height[left] <= height[right]){
            leftMax = Math.max(leftMax,height[left]);
            result += leftMax - height[left];
            left++;       
        }else{
            rightMax = Math.max(rightMax,height[right]);
            result += rightMax - height[right];
            right--;
        }
     }
     return result;
    }
}