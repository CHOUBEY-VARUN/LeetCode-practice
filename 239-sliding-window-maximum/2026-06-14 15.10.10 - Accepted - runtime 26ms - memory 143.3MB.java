class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int x = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.addLast(i);

            if (i >= k - 1) {

                ans[x] = nums[q.peekFirst()];
                x++;

                if (q.peekFirst() == left) {
                    q.pollFirst();
                }
                left++;
            }
        }
        return ans;
    }
}