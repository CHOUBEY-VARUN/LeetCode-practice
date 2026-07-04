class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;

        backtrack(candidates, 0, target, sum, path, result);
        return result;
    }

    public void backtrack(int[] candidates, int start, int target, int sum, List<Integer> path, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }else if(sum > target){return;}

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(candidates,i,target,sum+candidates[i],path,result);
            path.remove(path.size()-1);
        }

    }
}