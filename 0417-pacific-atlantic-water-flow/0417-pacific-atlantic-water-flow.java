class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for(int i = 0;i<heights[0].length;i++){
            travel(heights,0,i,pacific);
        }
        for(int i = 0;i<heights.length;i++){
            travel(heights,i,0,pacific);
        }
        for(int i = heights.length-1;i>=0;i--){
            travel(heights,i,heights[0].length-1,atlantic);
        }
        for(int i = heights[0].length-1;i>=0;i--){
            travel(heights,heights.length-1,i,atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i<heights.length;i++){
            for(int j = 0; j<heights[0].length; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    public void travel(int[][] heights, int r, int c, boolean[][] visited){
        if((r < 0)||(r>=heights.length)||(c<0)||(c>=heights[0].length))return;
        if(visited[r][c])return;
        visited[r][c] = true;

        if((r-1 >= 0)&&(heights[r-1][c] >= heights[r][c])){travel(heights,r-1,c,visited);}
        if((c-1 >= 0)&&(heights[r][c-1] >= heights[r][c])){travel(heights,r,c-1,visited);}
        if((r+1 < heights.length)&&(heights[r+1][c] >= heights[r][c])){travel(heights,r+1,c,visited);}
        if((c+1 < heights[0].length)&&(heights[r][c+1] >= heights[r][c])){travel(heights,r,c+1,visited);}

        return;
    }
}