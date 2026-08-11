class Solution {
    public int missingInteger(int[] nums) {
        int maxSum = nums[0];
        int prev = 0;
        int curr = 1;
        while(curr < nums.length && nums[curr] == nums[prev] + 1){
            maxSum += nums[curr];
            prev++;
            curr++;
        }
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        while(set.contains(maxSum)){
            maxSum++;
        }

        return maxSum;
    }
}