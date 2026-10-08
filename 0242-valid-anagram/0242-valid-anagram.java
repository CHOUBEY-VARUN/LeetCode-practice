class Solution {
    public boolean isAnagram(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        String sorted1 = new String(a);
        String sorted2 = new String(b);

        return sorted1.equals(sorted2);
    }
}