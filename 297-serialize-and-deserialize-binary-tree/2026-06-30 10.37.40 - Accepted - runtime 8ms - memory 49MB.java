public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        convertTree(root,sb);
        return sb.toString();
    }

    public void convertTree(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("N,");
            return;
        }

        sb.append(node.val).append(",");
        convertTree(node.left,sb);
        convertTree(node.right,sb);
    }

    public TreeNode deserialize(String data) {
        String[] extracted = data.split(",");
        Queue<String> q = new LinkedList<>();
        for(String val : extracted){
            q.offer(val);
        }
        
        return convertString(q);
    }

    public TreeNode convertString(Queue<String> q){
        String current = q.poll();

        if(current.equals("N"))return null;

        TreeNode node = new TreeNode(Integer.parseInt(current));
        node.left = convertString(q);
        node.right = convertString(q);

        return node;
    }
}
