class Solution {
    public boolean checkString(String s) {
        int a = -1;
        int b = s.length();

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == 'a'){
                a = Math.max(a,i);
            }else{
                b = Math.min(b,i);
            }
        }

        return a < b;
    }
}