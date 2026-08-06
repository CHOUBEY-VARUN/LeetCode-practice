class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];

        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0] <= current[1]){
                current = merger(current,intervals[i]);
            }else{
                result.add(current);
                current = intervals[i];
            }
        }
        result.add(current);
        return result.toArray(new int[0][]);
    }

    public int[] merger(int[] a, int[] b){
        int s1 = a[0];
        int s2 = b[0];
        int e1 = a[1];
        int e2 = b[1];

        return new int[]{Math.min(s1,s2), Math.max(e1,e2)};
    }
}