class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int ans = nums[0];

        for (int num : nums) {
            if (num == ans) {
                count++;
            } else {
                count--;
                if (count <= 0) {
                    ans = num;
                    count = 1;
                }
            }
        }
        return ans;
    }
}