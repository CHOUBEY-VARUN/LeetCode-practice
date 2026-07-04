class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        Map<Integer,Integer> map =new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            set.add(nums[i]);
        }
        int ans = 0;
        for(int n : map.keySet()){
            if(map.get(n)%k == 0){ans += n*map.get(n);}
        }
        return ans;
    }
}