/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> visited = new HashMap<>();
        return buildClone(node,visited);
    }

    public Node buildClone(Node node, Map<Node,Node> map){
        if(node == null || map.containsKey(node)){return map.get(node);}

        Node copy = new Node(node.val);
        map.put(node,copy);
        
        for(Node neighbor : node.neighbors){
            copy.neighbors.add(buildClone(neighbor,map));
        }
        return copy;
    }
}