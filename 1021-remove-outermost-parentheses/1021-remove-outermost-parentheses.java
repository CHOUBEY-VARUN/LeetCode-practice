class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (depth == 0) {
                    depth++;
                    continue;
                } else {
                    result.append(c);
                    depth++;
                }
            } else {
                depth--;
                if (depth == 0) {
                    continue;
                } else {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
}