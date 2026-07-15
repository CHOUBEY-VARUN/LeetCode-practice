class Solution {
    public int numDecodings(String s) {
        return search(s, 0, new HashMap<>());
    }

    public int search(String s, int curr, Map<Integer, Integer> memo )  {
        if(memo.containsKey(curr)) return memo.get(curr);
        if (curr >= s.length()){
            return 1;
            }
        if (s.charAt(curr) == '0')
            return 0;
        int ways = 0;

        if (s.charAt(curr) >= '1' && s.charAt(curr) <= '9') {
            ways += search(s, curr + 1, memo);
        }

        if (curr + 1 < s.length()) {
            if (Integer.parseInt(s.substring(curr, curr + 2)) >= 10
                    && Integer.parseInt(s.substring(curr, curr + 2)) <= 26) {
                ways += search(s, curr + 2, memo);
            }

        }

        memo.put(curr,ways);
        return ways;
    }
}