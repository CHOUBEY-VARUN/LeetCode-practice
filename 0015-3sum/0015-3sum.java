class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; i++){
            if((i>0) && (nums[i-1] == nums[i])){continue;}
            int a = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = a + nums[left] + nums[right];
                if(sum == 0){
                    result.add(new ArrayList<>(Arrays.asList(a,nums[left],nums[right])));
                    left++;
                    right--;
                    while((left<right)&&nums[left-1] == nums[left]){left++;}
                    while((left<right)&&nums[right+1] == nums[right]){right--;}
                }else if(sum > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return result;
    }
}