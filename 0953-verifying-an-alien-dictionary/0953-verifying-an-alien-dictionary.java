class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> abc = new HashMap<>();
        int x = 0;
        for (char c : order.toCharArray()) {
            abc.put(c, x);
            x++;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word = words[i];
            String next = words[i + 1];
            int len = Math.min(word.length(), next.length());
            boolean ans = false;

            for (int j = 0; j < len; j++) {
                int a = abc.get(word.charAt(j));
                int b = abc.get(next.charAt(j));
                if (a != b) {
                    if (a < b) {
                        ans = true;
                        break;
                    } else {
                        return false;
                    }
                }
            }
            if ((ans == false) && (word.length() > next.length())) {
                return false;
            }

        }
        return true;
    }
}