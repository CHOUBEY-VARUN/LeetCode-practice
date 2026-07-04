class Solution {
    private StringBuilder sb = new StringBuilder();
    public List<String> summaryRanges(int[] nums) {
      List<String> result = new ArrayList<>();
      int cur = 0;
      while(cur < nums.length){
        cur = set(nums,cur);
        result.add(sb.toString());
        sb.setLength(0);
      }
      return result;
    }
    public int set(int[] nums, int cur){
        sb.append(nums[cur]);
        int start = cur;
        while((cur+1<nums.length)&&(nums[cur+1]==nums[cur]+1)){
            cur++;
        }
        if(cur==start){cur+=1;return cur;}
        sb.append("->" + nums[cur]);
        cur += 1;
        return cur;
    }
}