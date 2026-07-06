class Solution {
    private int provinces = 0;
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        createGraph(isConnected.length, isConnected, graph);
        boolean[] visited = new boolean[isConnected.length];
        for(int i = 0; i<isConnected.length; i++){
            if(!visited[i]){
                provinces++;
                search(i,graph,visited);
                }
        }
        return provinces;
    }

    public void search(int current,ArrayList<ArrayList<Integer>> graph,boolean[] visited){
        visited[current] = true;

        for(int neighbour : graph.get(current)){
            if(!visited[neighbour]){search(neighbour,graph,visited);}
        }
    }

    public void createGraph(int n, int[][] edges, ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i<n ; i++){
            for(int j = 0; j<n ; j++){
                if(edges[i][j] == 1){
                    graph.get(i).add(j);
                }
            }
        }
    }
}