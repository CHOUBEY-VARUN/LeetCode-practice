class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int buy = cost.length-1;
        int result = 0;
        int counter = 2;
        while(buy >= 0){
            if(counter > 0){
                result += cost[buy];
                buy--;
                counter--;
            }else{
                counter = 2;
                buy--;
            }
        }
        return result;
    }
}