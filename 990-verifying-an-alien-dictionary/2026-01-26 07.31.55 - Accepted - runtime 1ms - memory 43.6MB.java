class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> map = new HashMap<>();
        int power = 1;
        for(char c : order.toCharArray()){map.put(c,power);power++;}
        for(int i = 0; i<words.length - 1;i++){
            boolean ans = false;
            String curr = words[i];
            String next = words[i+1];
            int n = Math.min(curr.length(),next.length());
            for(int j = 0; j<n; j++){
                if(map.get(curr.charAt(j)) == map.get(next.charAt(j))){
                    continue;
                    }else if(map.get(curr.charAt(j)) < map.get(next.charAt(j))){
                        ans = true;
                        break;
                        }else{
                        return false;
                        }
            }
            if(ans == false && curr.length() > next.length()){return false;}else{continue;}
        }
        return true;
    }
}