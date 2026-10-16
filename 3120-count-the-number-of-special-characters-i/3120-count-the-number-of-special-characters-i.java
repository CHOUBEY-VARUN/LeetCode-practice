class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[][] seen = new boolean[26][2];

        for(char c : word.toCharArray()){
            if(c >= 'a' && c <= 'z'){
                seen[c - 'a'][0] = true;
            }else if(c >= 'A' && c <= 'Z'){
                seen[c - 'A'][1] = true;
            }
        }

        int count = 0;
        for(int i = 0; i<26; i++){
            if(seen[i][0] && seen[i][1]){count++;}
        }

        return count;
    }
}