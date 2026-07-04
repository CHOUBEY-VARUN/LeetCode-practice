class Solution {
    public int countHillValley(int[] nums) {
        if (nums == null || nums.length < 3) return 0;

        // Step 1: compress consecutive duplicates in-place
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }

        // Step 2: count hills and valleys on the compressed array of length k
        int count = 0;
        for (int i = 1; i < k - 1; i++) {
            if ((nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) ||
                (nums[i] < nums[i - 1] && nums[i] < nums[i + 1])) {
                count++;
            }
        }

        return count;
    }
}
