class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }

        for(int row = 0; row<board.length; row++){
            for(int col = 0; col<board[0].length; col++){
                find(row,col,board,root);
            }
        }

        return result;
        
    }

    public void find(int row, int col, char[][]board, TrieNode node){
        if(row<0 || row>=board.length || col<0 || col>=board[0].length)return;

        char c = board[row][col];
        int index = c - 'a';
        if(c == '#' || node.children[index] == null)return;
        node = node.children[index];
        if(node.word!=null){
            result.add(node.word);
            node.word = null;
        }

        board[row][col] = '#';
        find(row+1,col,board,node);
        find(row-1,col,board,node);
        find(row,col+1,board,node);
        find(row,col-1,board,node);
        board[row][col] = c;

        return;
    }
}