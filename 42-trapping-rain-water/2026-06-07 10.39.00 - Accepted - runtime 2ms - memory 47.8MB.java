class Solution {
    public int trap(int[] height) {
        int left = 0;
        int leftMax = height[left];
        int right = height.length - 1;
        int rightMax = height[right];
        int ans = 0;
        while(left<right){
            leftMax = Math.max(height[left],leftMax);
            rightMax = Math.max(height[right],rightMax);

            if(height[left] <= height[right]){
                ans += leftMax - height[left];
                left++;
            }else{
                ans+= rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}