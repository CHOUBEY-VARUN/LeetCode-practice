class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int n : nums){seen.add(n);}
        int longest = 0;

        for(int x : seen){
            int length = 1;
            if(!seen.contains(x - 1)){
                while(seen.contains(x+1)){
                    length++;
                    x++;
                    }
            }
            longest = Math.max(longest,length);
        }
        return longest;
    }
}