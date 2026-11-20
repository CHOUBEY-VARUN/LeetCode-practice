class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){graph.add(new ArrayList<>());}

        for(int edge[] : prerequisites){
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
        }

        boolean[] visited = new boolean[numCourses]; 
        boolean[] path = new boolean[numCourses]; 

        for(int i = 0; i<numCourses; i++){
            if(!visited[i]){
                if(hasCycle(graph,i,visited,path)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasCycle(ArrayList<ArrayList<Integer>> graph,int curr, boolean[] visited, boolean[] path) {
        visited[curr] = true;
        path[curr] = true;

        for(int neighbor : graph.get(curr)){
            if(!visited[neighbor]){
                if(hasCycle(graph,neighbor,visited,path)){
                    return true;
                }
            }else if(path[neighbor]){
                return true;
            }
        }

        path[curr] = false;
        return false;
    }
}