class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[]ans=new int[m+n];
        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                ans[k]=nums1[i];
                i++;
            }else{
                ans[k]=nums2[j];
                j++;
            }
            k++;
        }
        while(j<n){
            ans[k]=nums2[j];
            j++;k++;
        }
        while(i<m){
            ans[k]=nums1[i];
            k++;i++;
        }
        for(int x = 0; x < m+n; x++){ 
            nums1[x] = ans[x];
        } // because we've to copy it to nums1 array only 
    }
}