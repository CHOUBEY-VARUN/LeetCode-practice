class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[k];

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for(int key : map.keySet()){
            q.offer(key);

            if(q.size()>k){q.poll();}
        }
        int idx = 0;
        while(idx < k){
            ans[idx] = q.poll();
            idx++;
        }
        return ans;
    }
}