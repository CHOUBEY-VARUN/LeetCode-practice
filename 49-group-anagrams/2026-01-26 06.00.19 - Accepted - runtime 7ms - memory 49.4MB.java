class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String i : strs){
            char[] s = i.toCharArray();
            Arrays.sort(s);
            String sorted = new String(s);
            map.computeIfAbsent(sorted, k->new ArrayList<>()).add(i);            
        }
        return new ArrayList<>(map.values());
    }
}