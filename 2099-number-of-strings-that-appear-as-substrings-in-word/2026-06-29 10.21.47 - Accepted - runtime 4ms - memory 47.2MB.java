class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int endCount = 0;
    }

    private void insert(TrieNode root, String word) {
        TrieNode curr = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
        }

        curr.endCount++;
    }

    public int numOfStrings(String[] patterns, String word) {
        TrieNode root = new TrieNode();

        for (String pattern : patterns) {
            insert(root, pattern);
        }

        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            TrieNode curr = root;

            for (int j = i; j < word.length(); j++) {
                int idx = word.charAt(j) - 'a';

                if (curr.children[idx] == null) {
                    break;
                }

                curr = curr.children[idx];

                if (curr.endCount > 0) {
                    count += curr.endCount;

                    // Prevent counting the same pattern again
                    curr.endCount = 0;
                }
            }
        }

        return count;
    }
}