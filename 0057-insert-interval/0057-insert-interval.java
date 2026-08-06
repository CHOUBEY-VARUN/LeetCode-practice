class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int current = 0;
        
        while(current < intervals.length && intervals[current][1] < newInterval[0]){
            ans.add(intervals[current]);
            current++;
        }

        
        while(current < intervals.length && intervals[current][0] <= newInterval[1]){
            newInterval = merge(intervals[current],newInterval);
            current++;
        }

        ans.add(newInterval);

        while(current < intervals.length){
            ans.add(intervals[current]);
            current++;
        }

        return ans.toArray(new int[0][]);

    }

    public int[] merge(int[] a, int[] b){
        int s1 = a[0];
        int s2 = b[0];
        int e1 = a[1];
        int e2 = b[1];

        return new int[]{Math.min(s1,s2),Math.max(e1,e2)};
    }
}