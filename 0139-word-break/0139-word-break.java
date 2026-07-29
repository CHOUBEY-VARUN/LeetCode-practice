class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dict = new boolean[s.length()+1];
        dict[s.length()] = true;

        for(int i = s.length()-1; i>=0; i--){
            for(String word : words){
                if(s.startsWith(word,i) && dict[i+word.length()]){
                    dict[i] = true;
                }
            }
        }
        return dict[0];
    }
}