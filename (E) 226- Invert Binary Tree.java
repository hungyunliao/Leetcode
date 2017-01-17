/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        // a helper function reverts its left and right children
        revert(root);
        return root;
    }
    
    private void revert(TreeNode node) {
        if(node == null) {
            return;
        }
        TreeNode left = null, right = null;
        if(node.left != null) {
            left = node.left;
        }
        if(node.right != null) {
            right = node.right;
        }
        node.left = right;
        node.right = left;
        revert(node.left);
        revert(node.right);
    }
}
