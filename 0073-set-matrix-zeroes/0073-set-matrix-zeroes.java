class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int row = 0; row<matrix.length; row++){
            for(int col = 0; col<matrix[0].length; col++){
                if(matrix[row][col] == 0){
                    rows.add(row);
                    cols.add(col);
                }
            }
        }

        for(int row : rows){
            for(int col = 0; col<matrix[0].length; col++){
                matrix[row][col] = 0;
            }
        }

        for(int col : cols){
            for(int row = 0; row<matrix.length; row++){
                matrix[row][col] = 0;
            }
        }
    }
}