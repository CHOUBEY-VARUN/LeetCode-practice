class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){return false;}
        int n = 0;
        int d = x;
        while(d!=0){
            n = n*10 + d%10;
            d /= 10;
        }
        if(x==n){return true;}else{System.out.print(n);return false;}
    }
}