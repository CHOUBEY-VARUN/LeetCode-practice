class Solution {
    public int calPoints(String[] operations) {
        int[] ans = new int[operations.length];
        int curr = 0;
        int sum = 0;
        for(int i = 0; i<operations.length; i++){
            if(operations[i].equals("+")){
                ans[curr] = ans[curr-2]+ans[curr-1];
                curr++;
            }else if(operations[i].equals("C")){
                ans[curr-1] = 0;
                curr--;
            }else if(operations[i].equals("D")){
                ans[curr] = 2*ans[curr-1];
                curr++;
            }else{
                ans[curr] = Integer.parseInt(operations[i]);
                curr++;
            }
        }
        for(int num : ans){sum += num;}
        return sum;
    }
}