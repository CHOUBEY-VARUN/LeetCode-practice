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
    private int index = 0;
    private Map<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }    

        return split(preorder,0,inorder.length-1);
    }

    public TreeNode split(int[] preorder, int left, int right){
        if(left>right)return null;

        TreeNode node = new TreeNode(preorder[index]);
        int mid = map.get(preorder[index]);
        index++;

        node.left = split(preorder,left,mid-1);
        node.right = split(preorder,mid+1,right);

        return node; 
    } 
}