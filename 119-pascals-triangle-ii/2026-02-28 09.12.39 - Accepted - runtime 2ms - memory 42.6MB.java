class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex==0){return new ArrayList<>(Arrays.asList(1));}
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i<=rowIndex; i++){
            List<Integer> cur = new ArrayList<>(); 
            for(int j = 0; j<=i; j++){
                if(j==0||j==i){
                    cur.add(1);
                    }else{
                cur.add((result.get(i-1).get(j-1))+(result.get(i-1).get(j)));}
            }
            result.add(cur);
        }
        return result.get(result.size()-1);
    
        
    }
}