class Solution {
    public int reverseDegree(String s) {
        int sum = 0;

        for(int i = 0; i<s.length(); i++){
            int product = (i+1)*(('z' - s.charAt(i) + 1));
            sum += product;
        }

        return sum;
    }
}