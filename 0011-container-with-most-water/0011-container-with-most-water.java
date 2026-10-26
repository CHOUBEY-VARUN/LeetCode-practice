class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = Integer.MIN_VALUE;

        while(left < right){
            if(height[left] <= height[right]){
                int area = (right-left)*height[left];
                max = Math.max(max,area);
                left++;
            }else{
                int area = (right-left)*height[right];
                max = Math.max(max,area);
                right--;
            }
        }
        return max;
    }
}