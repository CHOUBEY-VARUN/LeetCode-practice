class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.putAll(Map.of('I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000));
        int sum = map.get(s.charAt(s.length() - 1));
        for(int i = s.length()-2; i>=0; i--){
            int curr = map.get(s.charAt(i));
            int prev = map.get(s.charAt(i+1));
            if(curr >= prev){
                sum += curr;
                }else{
                    sum -= curr;
                    }
        }
        return sum;
    }
}