class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return hasPath(graph,source,destination,new boolean[n]);
    }

    public boolean hasPath(ArrayList<ArrayList<Integer>> graph, int s, int d, boolean[] visited){
        if(s == d)return true;
        visited[s] = true;

        for(int neighbor : graph.get(s)){
            if(!visited[neighbor]){
                if(hasPath(graph,neighbor,d,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}