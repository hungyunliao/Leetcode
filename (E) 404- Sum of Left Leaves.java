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
    public int sumOfLeftLeaves(TreeNode root) {
        // create a helper function with arguement (node, sum, left or right)
        // Base case: if the node is a leaf and it's left node of parent, return val; otherwise, return 0;
        // other case: return sum + rightChild + leftChild;
        
        // corner case:
        if(root == null) {
            return 0;
        }
        int left = 0, right = 0;
        if(root.left != null) left = helper(root.left, true);
        if(root.right != null) right = helper(root.right, false);
        return left + right;
        
    }
    
    private int helper(TreeNode node, boolean isLeft) {
        if(node.left == null && node.right == null) {
            if(isLeft) {
                return node.val;
            } else {
                return 0;
            }
        }
        int left = 0, right = 0;
        if(node.left != null) left = helper(node.left, true);
        if(node.right != null) right = helper(node.right, false);
        
        return left + right;
    }
}
