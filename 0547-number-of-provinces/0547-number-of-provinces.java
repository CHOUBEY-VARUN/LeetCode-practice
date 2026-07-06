class Solution {
    private int provinces = 0;
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        for(int i = 0; i<isConnected.length; i++){
            if(!visited[i]){
                provinces++;
                search(i,isConnected,visited);
                }
        }
        return provinces;
    }

    public void search(int current,int[][] isConnected,boolean[] visited){
        visited[current] = true;

        for(int neighbour = 0; neighbour < isConnected.length; neighbour++){
            if(isConnected[current][neighbour] == 1 && !visited[neighbour]){
                search(neighbour,isConnected,visited);
            }
        }
    }
}