class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int length = 0;
        Set<Character> abc = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (abc.contains(c)) {
                abc.remove(s.charAt(left));
                left++;
            }
                abc.add(c);
                length = Math.max(length, abc.size());
            

        }
            return length;
    }
}
