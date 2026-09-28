class Solution {
    public int maxDepth(String s) {
        int max = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(c);
                max = Math.max(max,stack.size());
            }else if(c == ')'){
                stack.poll();
            }else{continue;}
        }

        return max;
    }
}