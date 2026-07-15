class Solution {
    private String result = "";
    public String longestPalindrome(String s) {
        for(int i = 0; i<s.length(); i++){
            search(s,i,i+1);
            search(s,i,i);
        }

        return result;
    }

    public void search(String s, int left, int right){
        if(left>=0 && right < s.length()){
            if(s.charAt(left) != s.charAt(right)) return;

            if(result.length() < (right - left +1)){
                result = s.substring(left,right+1);
            }

            search(s,left-1,right+1);
        }

        return; 
    }
}