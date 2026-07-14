class Solution {
    public int rob(int[] nums) {
        return adjSum(nums,0,new HashMap<>());
    }

    public int adjSum(int[] nums, int n, Map<Integer,Integer> memo){
        if(n >= nums.length) return 0;

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        int result = Math.max(
            nums[n] + adjSum(nums,n+2,memo),
            adjSum(nums,n+1,memo)
        );
        memo.put(n,result);

        return result;
    }
}