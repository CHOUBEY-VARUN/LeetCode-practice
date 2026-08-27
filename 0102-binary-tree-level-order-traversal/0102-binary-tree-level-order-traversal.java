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
        if(root == null)return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while(!stack.isEmpty()){
            int n = stack.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i<n; i++){
                TreeNode curr = stack.pollFirst();
                temp.add(curr.val);
                if(curr.left!=null)stack.addLast(curr.left);
                if(curr.right!=null)stack.addLast(curr.right); 
            }
            result.add(temp);
        }
        return result;
    }
}