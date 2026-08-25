class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        int curr = k;
        while (count < nums.length) {
            if (!set.contains(curr)) {
                return curr;
            } else {
                curr += k;
                count++;
            }
        }
        return curr;
    }
}