class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int[] current = intervals[0];
        int result = 0;

        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0] < current[1]){
                result++;
                current = intervals[i][1] <= current[1] ? intervals[i] : current;
                }
                else{
                    current = intervals[i];
                }
        }

        return result;
    }
}