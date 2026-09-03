class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            String s = SortStr(str);
            map.computeIfAbsent(s, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public String SortStr(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}