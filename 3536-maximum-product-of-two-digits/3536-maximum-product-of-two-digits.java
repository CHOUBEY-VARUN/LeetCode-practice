class Solution {
    public int maxProduct(int n) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        while(n > 0){
            int digit = n % 10;
            q.add(digit);
            if(q.size()>2){q.poll();}
            n /= 10;
        }
        int result = 1;
        while(!q.isEmpty()){
            result *= q.poll();
        }
        return result;
    }
}