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
    public int minDepth(TreeNode root) {
        if (root == null) { return 0; }
        return helper(1, root);
    }
    
    public int helper(int currentDepth, TreeNode node) {
        if (node.left == null && node.right == null) {
            return currentDepth;
        }
        
        if (node.left == null) {
            return helper(currentDepth + 1, node.right);
        } else if (node.right == null) {
            return helper(currentDepth + 1, node.left);
        }
        else return Math.min(helper(currentDepth + 1, node.left), helper(currentDepth + 1, node.right));
    }
}
