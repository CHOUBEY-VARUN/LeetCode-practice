class Solution {
    public int trap(int[] height) {
        int left = 0;
        int leftmax = height[left];
        int right = height.length-1;
        int rightmax = height[right];
        int sum = 0;

        while(left<right){
            if(height[left] <= height[right]){
                leftmax = Math.max(leftmax,height[left]);
                sum += leftmax - height[left];
                left++;
            }else{
                rightmax = Math.max(rightmax,height[right]);
                sum += rightmax - height[right];
                right--;
            }
        }
        return sum;
    }
}