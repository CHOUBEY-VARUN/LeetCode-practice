class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        int j = 0;


        for(int i = 0; i<nums1.length; i++){
            if(i>j){j = i;}
            while(j<nums2.length && nums1[i] <= nums2[j]){
                max = Math.max(max, j-i);
                j++; 
            }
        }
        
        return max;
    }
}