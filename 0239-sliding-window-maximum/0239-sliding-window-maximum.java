class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> pq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for(int i = 0; i<nums.length; i++){
            while(!pq.isEmpty() && pq.peekFirst() <= i - k){
                pq.pollFirst();
            }

            while(!pq.isEmpty() && nums[pq.peekLast()] <= nums[i]){
                pq.pollLast();
            }

            pq.offerLast(i);

            if(i >= k-1){
                result[i-k+1] = nums[pq.peekFirst()];
            }
        }
        return result;
    }
}