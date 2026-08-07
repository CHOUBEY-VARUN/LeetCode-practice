class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        int result = 0;
        int[] current = intervals[0];

        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0] < current[1]){
                result++;
                current = new int[]{(Math.min(intervals[i][0],current[0])), (Math.min(intervals[i][1],current[1]))};
            }else{
                current = intervals[i];
            }
        }

        return result;
    }
}