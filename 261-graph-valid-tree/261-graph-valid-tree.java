class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1)return false;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        dfs(0,graph,visited);
        for(boolean visit : visited){
            if(!visit)return false;
        }
        return true;
    }

    public void dfs(int curr,ArrayList<ArrayList<Integer>> graph,boolean[] visited){
        if(visited[curr])return;

        visited[curr] = true;

        for(int neighbour : graph.get(curr)){
            if(!visited[neighbour]){
                dfs(neighbour,graph,visited);
            }
        }
    }
}
