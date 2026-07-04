class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            int left = i - 1;
            int right = i + 1;
            int len = 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                len += 2;
                if (len > maxLen) {
                    maxLen = len;
                    start = left;
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            int newLen = 0;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                newLen += 2;
                if (newLen > maxLen) {
                    maxLen = newLen;
                    start = left;

                }
                left--;
                right++;
            }
        }
        return s.substring(start, start + maxLen);
    }
}