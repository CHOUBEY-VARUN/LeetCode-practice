class Solution {
    public int reverseBits(int n) {
        StringBuilder reversed = new StringBuilder();
        for(int i = 0; i<32; i++){
            reversed.append(n & 1);
            n >>>= 1;
        }
        return Integer.parseInt(reversed.toString(),2);
    }
}