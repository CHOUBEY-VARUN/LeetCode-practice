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
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        StringBuilder num = new StringBuilder();
        pathSum(root, num);
        return sum;
    }

    public void pathSum(TreeNode node, StringBuilder num) {
        if (node == null) {
            return;
        }
        num.append(node.val);

        if (node.left == null && node.right == null) {
            sum += Integer.parseInt(num.toString());
        } else {
            pathSum(node.left, num);
            pathSum(node.right, num);
        }
            num.deleteCharAt(num.length() - 1);
    }
}