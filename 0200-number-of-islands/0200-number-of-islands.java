class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    check(i,j,grid,visited,count);
                    count++;
                }
            }
        }
        return count;
    }

    public void check(int i, int j, char[][] grid, boolean[][] visited, int count){
        if((i < 0) || (j < 0) || (i >= grid.length) || (j >= grid[0].length) || (grid[i][j] == '0') || (visited[i][j])){
            return;
        }

        char curr = grid[i][j];
        visited[i][j] = true;
        check(i+1,j,grid,visited,count);
        check(i-1,j,grid,visited,count);
        check(i,j+1,grid,visited,count);
        check(i,j-1,grid,visited,count);
        return;
    }
}