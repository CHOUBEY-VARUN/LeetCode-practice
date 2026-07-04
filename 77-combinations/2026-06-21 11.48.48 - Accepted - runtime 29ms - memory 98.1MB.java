class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(1,n,path,result,k);
        return result;
    }

    public void backtracking(int start, int end, List<Integer> path, List<List<Integer>> result, int k){
        if(path.size() == k){
            result.add(new ArrayList<>(path));
        }

        for(int i = start; i<=end; i++){
            path.add(i);
            backtracking(i+1,end,path,result,k);
            path.remove(path.size()-1);
        }
    }
}