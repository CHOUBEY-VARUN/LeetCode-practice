class Solution {
    public boolean exist(char[][] board, String word) {
        for(int row = 0; row<board.length; row++){
            for(int col = 0; col<board[0].length; col++){
                if(backtrack(board,word,row,col,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int row, int col, int idx){
        if(idx == word.length()){return true;}

        if((row<0)||(col<0)||(row>=board.length)||(col>=board[0].length)||(board[row][col] != word.charAt(idx))){
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = backtrack(board,word,row+1,col,idx+1) || backtrack(board,word,row-1,col,idx+1) || backtrack(board,word,row,col+1,idx+1) || backtrack(board,word,row,col-1,idx+1);

        board[row][col] = temp;
        return found;
    }
}