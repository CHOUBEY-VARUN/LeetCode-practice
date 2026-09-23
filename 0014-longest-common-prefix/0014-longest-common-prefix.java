class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }
    private TrieNode root = new TrieNode();
    
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        TrieNode current = buildTrie(strs,root);

        while(current != null){
            int childCount = 0;
            int next = -1;

            for(int i = 0; i<26; i++){
                if(current.children[i] != null){
                    childCount++;
                    next = i; 
                }
            }

            if(childCount != 1){break;}
            if(current.isEnd){break;}

            prefix.append((char)('a'+ next));
            current = current.children[next];
        }
        return prefix.toString();
    }

    public TrieNode buildTrie(String[] strs, TrieNode node){
        TrieNode root = node;
        for(String str : strs){
            for(char c : str.toCharArray()){
                int index = c - 'a';
                if(node.children[index] == null){
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEnd = true;
            node = root;
        }
        return root;
    }
}