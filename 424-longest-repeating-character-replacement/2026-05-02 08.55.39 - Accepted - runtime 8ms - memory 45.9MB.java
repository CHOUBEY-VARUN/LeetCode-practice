class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        int window = 0;
        int max = 0;
        int left = 0;
        int[] abc = new int[128];
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            abc[c]++;
            max = Math.max(max, abc[c]);
            if (((right - left + 1) - max) <= k) {
                window = Math.max(window, right - left + 1);
            } else {
                abc[s.charAt(left)]--;
                left++;
            }
        }

        return window;
    }
}