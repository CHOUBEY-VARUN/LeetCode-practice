class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int depth = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if(c == '('){
                depth++;
                max = Math.max(max,depth);
            }else if(c == ')'){
                depth--;
            }else{continue;}
        }

        return max;
    }
}