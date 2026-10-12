class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1 && trust.length == 0)return 1;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i<trust.length; i++){
            int a = trust[i][0];
            int b = trust[i][1];
            map.put(a,map.getOrDefault(a,0)-1);
            map.put(b,map.getOrDefault(b,0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == n-1){return entry.getKey();}
        }
        return -1;
    }
}