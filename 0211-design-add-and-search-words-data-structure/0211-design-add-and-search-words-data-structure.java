class WordDictionary {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;

        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        return searcher(word,root);
    }

    public boolean searcher(String word, TrieNode current){
        for(int i = 0;i < word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(TrieNode child : current.children){
                    if(child != null && searcher(word.substring(i+1),child)){
                        return true;
                        }
                }
                return false;
            }else{
                int index = c - 'a';
                if(current.children[index] == null){
                    return false;
                }
                current = current.children[index];
            }
        }
        return current.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */