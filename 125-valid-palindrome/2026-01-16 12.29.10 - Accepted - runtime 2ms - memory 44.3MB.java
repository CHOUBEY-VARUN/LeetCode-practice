class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 1){return true;}
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
        while(left < right && !Character.isLetterOrDigit(s.charAt(left))){left++;}
        while(right > left && !Character.isLetterOrDigit(s.charAt(right))){right--;}
        char l = s.charAt(left);
        char r = s.charAt(right);
        if(Character.toLowerCase(l) == (Character.toLowerCase(r))){
            left++;
            right--;
            continue;
            }
            else{
                return false;
                }
        }
        return true;
    }
}