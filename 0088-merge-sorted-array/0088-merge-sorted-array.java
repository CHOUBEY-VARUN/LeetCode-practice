class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = nums1.length-1;
        m--;
        n--;
        while(m >= 0 && n >= 0){
            if(nums1[m] >= nums2[n]){
                nums1[x] = nums1[m];
                x--;
                m--;
            }else{
                nums1[x] = nums2[n];
                x--;
                n--;
            }
        }

        if(m == -1){
            while(n >= 0){
                nums1[x] = nums2[n];
                x--;
                n--;
            }
        }else{
            while(m >= 0){
                nums1[x] = nums1[m];
                x--;
                m--;
            }
        }
    }
}