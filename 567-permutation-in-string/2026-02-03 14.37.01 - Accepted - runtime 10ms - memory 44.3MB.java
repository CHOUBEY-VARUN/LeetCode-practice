class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] str1 = new int[26];
        int[] str2 = new int[26];
        for(char c : s1.toCharArray()){str1[c - 'a']++;}
        int left = 0;
        for(int right = 0; right < s2.length(); right++){
            char c = s2.charAt(right);
            str2[c - 'a']++;
            if(right - left + 1 == s1.length()){
                if(Arrays.equals(str1,str2)){return true;}
                str2[s2.charAt(left) - 'a']--;
                left++;
            }
        }
        return false;
    }
}