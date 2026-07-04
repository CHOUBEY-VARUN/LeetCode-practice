class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int x = 0;
        int y = n;
        for(int i = 0; i<ans.length; i++){
            if(i%2 == 0){
                ans[i] = nums[x];
                x++;
            }
            else{
                ans[i] = nums[y];
                y++;
                }
        }
        return ans;
    }
}