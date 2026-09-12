class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> abc = new HashMap<>(Map.of('I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000));
        int result = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            if(i == s.length()-1){result += abc.get(s.charAt(i));}
            if(i < s.length()-1){
                int curr = abc.get(s.charAt(i));
                int prev = abc.get(s.charAt(i+1));
                if(prev <= curr){result += curr;}else{result -= curr;}
            }
        }
        
        return result;
    }
}