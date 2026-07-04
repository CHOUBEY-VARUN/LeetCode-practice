class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root = new TrieNode();

    private void insert(List<String> dictionary) {
        for (String word : dictionary) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }
    }

    private String find(String word) {
        TrieNode node = root;
        StringBuilder cur = new StringBuilder();

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null)
                return word;

            cur.append(c);
            node = node.children[index];

            if (node.isEnd) {
                return cur.toString();
            }
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        insert(dictionary);
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(find(word)).append(" ");
        }

        return result.toString().trim();

    }
}
