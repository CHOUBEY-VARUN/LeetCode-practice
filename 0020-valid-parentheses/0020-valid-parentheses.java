class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(c == ')'){
                if((!stack.isEmpty())&&(stack.peek() == '(')){stack.poll();}else{stack.push(c);}
            }else if(c == '}'){
                if((!stack.isEmpty())&&(stack.peek() == '{')){stack.poll();}else{stack.push(c);}
            }else if(c == ']'){
                if((!stack.isEmpty())&&(stack.peek() == '[')){stack.poll();}else{stack.push(c);}
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}