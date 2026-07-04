class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(backtrack(board,word,0,i,j)){return true;}
            }
        } 
        return false;
    }

    public boolean backtrack(char[][]board,String word, int ind, int row , int col){
        if(ind>=word.length()){
            return true;
            }
        if((row < 0)||(row >= board.length)||(col < 0)||(col >= board[0].length)||(board[row][col] != word.charAt(ind))){
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = backtrack(board,word,ind+1,row+1,col) || backtrack(board,word,ind+1,row-1,col) || backtrack(board,word,ind+1,row,col+1) || backtrack(board,word,ind+1,row,col-1);

        board[row][col] = temp;
        return found;
    }
}