/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        if(root!=null){stack.addFirst(root);}else{return result;}

        while(!stack.isEmpty()){
            int size = stack.size();
            List<Integer> level = new ArrayList<>();
            while(size>0){
                TreeNode curr = stack.removeLast();
                if(curr.left!=null)stack.addFirst(curr.left);
                if(curr.right!=null)stack.addFirst(curr.right);
                level.add(curr.val);
                size--;
            }
            result.add(level);
        }
        return result;
    }
}