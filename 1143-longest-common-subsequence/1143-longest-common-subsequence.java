class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i = 0; i < text1.length(); i++){
            Arrays.fill(dp[i],-1);
        }
        return result(0,0,text1,text2,dp);
    }

    public int result(int row, int col, String text1, String text2, int[][] dp){
        if(row >= text1.length() || col >= text2.length()){
            return 0;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        if(text1.charAt(row) == text2.charAt(col)){
            int x = result(row+1,col+1,text1,text2,dp) + 1;
            dp[row][col] = x;
            return dp[row][col];
        }

        int down = result(row+1,col,text1,text2,dp);
        int right = result(row,col+1,text1,text2,dp);
        dp[row][col] = Math.max(down,right);

        return dp[row][col];
    }
}