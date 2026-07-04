class Solution {
    public int smallestEvenMultiple(int n) {
        int val = n;
        while(val%2!=0 || val%n!=0){
            val++;
        }
        return val;
    }
}