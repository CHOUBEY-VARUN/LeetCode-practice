class Solution {
    public String minWindow(String s, String t) {
        int start = 0;
        int left = 0;
        int len = 0;

        int[] abc = new int[128];
        for (char c : t.toCharArray()) {
            abc[c]++;
        }
        int need = t.length();
        int have = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (abc[c] > 0) {
                have++;
            }
            abc[c]--;

            while (have == need) {
                if (right - left + 1 < len || len == 0) {
                    start = left;
                    len = right - left + 1;
                }
                char leftc = s.charAt(left);
                left++;
                if(abc[leftc] >= 0){have--;}
                abc[leftc]++;
            }
        }
        return s.substring(start, start+len);
    }
}