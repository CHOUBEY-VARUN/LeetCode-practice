class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int num : nums){
            Deque<Integer> q = new ArrayDeque<>();
            while(num > 0){
                int digit = num % 10;
                q.addFirst(digit);
                num /= 10;
            }
            result.addAll(q);
        }
         return result.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}