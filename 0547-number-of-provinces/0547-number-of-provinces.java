class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<isConnected.length; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<isConnected.length; i++){
            for(int j = 0; j<isConnected[i].length; j++){
                if(isConnected[i][j] == 1){
                    graph.get(i).add(j);
                }
            }
        }

        int provinces = 0;
        boolean[] visited = new boolean[isConnected.length];
        for(int i = 0; i<isConnected.length; i++){
            if(!visited[i]){
                travel(i,graph,visited);
                provinces++;
            }
        }
        return provinces;
    }

    public void travel(int curr, ArrayList<ArrayList<Integer>> graph, boolean[] visited){
        if(visited[curr])return;
        visited[curr] = true;

        for(int neighbor : graph.get(curr)){
            if(!visited[neighbor]){
                travel(neighbor,graph,visited);
            }
        }
        return;
    }
}