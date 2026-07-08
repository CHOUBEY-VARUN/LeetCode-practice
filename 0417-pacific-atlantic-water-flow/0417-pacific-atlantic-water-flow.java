class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacificVisited = new boolean[heights.length][heights[0].length];
        boolean[][] atlanticVisited = new boolean[heights.length][heights[0].length];
        for(int row = 0; row<heights.length; row++){
            visit(row,0,heights,pacificVisited,heights[row][0]);
            visit(row,heights[0].length-1,heights,atlanticVisited,heights[row][heights[0].length-1]);
        }
        for(int col = 0; col<heights[0].length; col++){
            visit(0,col,heights,pacificVisited,heights[0][col]);
            visit(heights.length-1,col,heights,atlanticVisited,heights[heights.length-1][col]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int row = 0; row<heights.length; row++){
            for(int col = 0; col<heights[0].length; col++){
                if(pacificVisited[row][col] && atlanticVisited[row][col]){
                    result.add(Arrays.asList(row,col));
                }
            }
        }
        return result;
    }

    public void visit(int row, int col, int[][] heights,boolean[][] visited,int prev){
        if(row<0 || row>=heights.length || col<0 || col>=heights[0].length || heights[row][col] < prev || visited[row][col])return;
    
        
        int next = heights[row][col];
        visited[row][col] = true;
        
        visit(row+1,col,heights,visited,next);
        visit(row-1,col,heights,visited,next);
        visit(row,col+1,heights,visited,next);
        visit(row,col-1,heights,visited,next);
    }
}