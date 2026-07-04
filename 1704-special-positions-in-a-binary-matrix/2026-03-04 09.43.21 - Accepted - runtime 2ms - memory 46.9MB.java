class Solution {
    private int result = 0;

    public int numSpecial(int[][] mat) {
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (mat[row][col] == 1) {
                    if (check(mat, row, col))
                        result++;
                }
            }
        }
        return result;
    }

    public boolean check(int[][] mat, int i, int j){
        for(int a = 0; a<mat.length; a++){
            if(a!=i && mat[a][j] == 1)return false;
        }
        
        for(int b = 0; b<mat[0].length; b++){
            if(b!=j && mat[i][b] == 1)return false;
        }

        return true;
    }
}