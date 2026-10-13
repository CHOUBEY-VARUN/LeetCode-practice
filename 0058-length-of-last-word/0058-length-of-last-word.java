class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;
        int right = s.length()-1;

        while(s.charAt(right)==' '){
            right--;
        }

        while(right >= 0 && s.charAt(right)!=' '){
            result++;
            right--;
        }

        return result;
    }
}