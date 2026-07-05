class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        createGraph(n,edges,graph);
        boolean[] visited = new boolean[n];
        return search(source,destination,graph,visited);
    }

    public boolean search(int curr, int dest, ArrayList<ArrayList<Integer>> graph, boolean[] visited){
        if(curr == dest)return true;

        visited[curr] = true;
        for(int neighbour : graph.get(curr)){
            if(!visited[neighbour]){
                if(search(neighbour,dest,graph,visited))return true;
            }
        }

        return false;
    }

    public void createGraph(int n, int[][]edges,ArrayList<ArrayList<Integer>> graph){
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];

                graph.get(u).add(v);
                graph.get(v).add(u);
            }
    }
}