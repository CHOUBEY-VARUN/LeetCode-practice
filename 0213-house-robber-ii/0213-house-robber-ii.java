class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        return Math.max(
                adjSum(nums, 0, new HashMap<>(), 0),
                adjSum(nums, 0, new HashMap<>(), nums.length - 1));
    }

    public int adjSum(int[] nums, int n, Map<Integer, Integer> memo, int avoid) {
        if (n >= nums.length)
            return 0;
        if (n == avoid) {
            return adjSum(nums, n + 1, memo, avoid);
        }

        if (memo.containsKey(n))
            return memo.get(n);

        int result = Math.max(
                nums[n] + adjSum(nums, n + 2, memo, avoid),
                adjSum(nums, n + 1, memo, avoid));
        memo.put(n, result);

        return result;
    }
}