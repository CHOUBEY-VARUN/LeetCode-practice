class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i<queries.length; i++){
            String q = queries[i];
            for(String word : dictionary){
                int diff = 0;
                for(int c = 0; c<word.length(); c++){
                    if(!(word.charAt(c)==q.charAt(c))){
                        diff++;
                    }
                }
                if(diff <= 2){
                    result.add(q);
                    break;
                }
            }
        }
        return result;
    }
}