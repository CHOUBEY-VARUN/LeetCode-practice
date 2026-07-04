class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int maxCount = 0;
        Set<String> prefixes = new HashSet<>();
        for (int num : arr1) {
            String s = Integer.toString(num);
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(c);
                prefixes.add(sb.toString());
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            String s = Integer.toString(arr2[i]);
            StringBuilder sb = new StringBuilder();
            int curr = 0;
            for (char c : s.toCharArray()) {
                sb.append(c);
                if(prefixes.contains(sb.toString())){curr++;}else{break;}
                maxCount = Math.max(maxCount,curr);
            }
        }
        return maxCount;
    }
}