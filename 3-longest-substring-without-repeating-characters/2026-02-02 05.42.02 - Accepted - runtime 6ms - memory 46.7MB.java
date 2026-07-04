class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int length = 0;
        for(int right = 0; right <s.length(); right++){
            char x = s.charAt(right);
            while(set.contains(x)){
                set.remove(s.charAt(left));
                left++;
                length--;
            }
            set.add(x);
            length++;
            ans = Math.max(ans,length);
        }
        return ans;
    }
}