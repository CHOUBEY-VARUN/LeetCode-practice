class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for(int i = 0; i<numCourses; i++){
            if(!visited[i]){
                if(hasCycle(i,graph,visited,path)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasCycle(int current,  ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] path){
        visited[current] = true;
        path[current] = true;

        for(int neighbour : graph.get(current)){
            if(!visited[neighbour]){
                if(hasCycle(neighbour,graph,visited,path)){
                    return true;
                }
            }else if(path[neighbour]){
                return true;
            }
        }

        path[current] = false;
        return false;
    }
}