class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int r = 0;
        int sum = 0;
        while(r < k){sum+=nums[r];r++;}
        double avg = (double)sum/k;
        for(int right = k; right<nums.length; right++){
            sum -= nums[left];
            left++;
            sum += nums[right];
            avg = Math.max((double)sum/k, avg);
        }
        return avg;
    }
}