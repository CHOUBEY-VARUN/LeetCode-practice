class Solution {
    public boolean isValid(String s) {
        if (s.length() < 2)
            return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.addFirst(c);
            } else {
                if (stack.isEmpty())
                    return false;
                if (c == ')') {
                    if (stack.peekFirst() == '(') {
                        stack.removeFirst();
                    } else {
                        stack.addFirst(c);
                    }
                } else if (c == '}') {
                    if (stack.peekFirst() == '{') {
                        stack.removeFirst();
                    } else {
                        stack.addFirst(c);
                    }
                } else if (c == ']') {
                    if (stack.peekFirst() == '[') {
                        stack.removeFirst();
                    } else {
                        stack.addFirst(c);
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}