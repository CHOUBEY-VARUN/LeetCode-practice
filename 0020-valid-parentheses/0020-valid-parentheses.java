class Solution {
    public boolean isValid(String s) {
        Deque<Character> q = new ArrayDeque<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                q.addLast(c);
            }else if(c == ')'){
                if(!q.isEmpty() && q.peekLast() == '('){
                    q.removeLast();
                }else{
                    return false;
                }
            }else if(c == ']'){
                if(!q.isEmpty() && q.peekLast() == '['){
                    q.removeLast();
                }else{
                    return false;
                }

            }else if(c == '}'){
                if(!q.isEmpty() && q.peekLast() == '{'){
                    q.removeLast();
                }else{
                    return false;
                }
            }
        }

        if(q.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}