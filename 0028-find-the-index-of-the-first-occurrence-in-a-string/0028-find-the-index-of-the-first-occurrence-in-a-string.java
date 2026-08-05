class Solution {
    public int strStr(String haystack, String needle) {
        int ans = -1;
        int x = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(x)) {
                int left = i + 1;
                x++;
                while (left < haystack.length() && x < needle.length()) {
                    if (haystack.charAt(left) == needle.charAt(x)) {
                        left++;
                        x++;
                    }else{break;}
                }
                if (x == needle.length()){
                    return i;
                }else{x = 0;}
            }
        }
        return -1;
    }
}