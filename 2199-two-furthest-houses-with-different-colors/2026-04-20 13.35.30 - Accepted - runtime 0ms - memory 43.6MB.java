class Solution {
    public int maxDistance(int[] colors) {
        int left = 0;
        int right = colors.length-1;
        int max = 0;

        while(left<right && colors[left] == colors[right]){
            right--;
        }
        max = Math.abs(left-right);
        right = colors.length-1;
        
        while(left<right && colors[left]==colors[right]){
            left++;
        }

        return Math.max(max, Math.abs(left-right));
    }
}