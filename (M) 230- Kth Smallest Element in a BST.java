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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode prevNode = root;
        TreeNode nextNode = null;
        
        int min = 0;
        
        while(k-- > 0) {
            prevNode = root;
            
            if(prevNode.left != null) {
                nextNode = prevNode.left;
            } else if(prevNode.right != null) {
                min = prevNode.val;
                root = prevNode.right;
                continue;
            } else {
                // root has no child.
                return root.val;
            }
            
            // root has a left child
            while(nextNode.left != null) {
                prevNode = nextNode;
                nextNode = nextNode.left;
            }
            min = nextNode.val;
            if(nextNode.right != null) {
                prevNode.left = nextNode.right;
            }
            else {
                prevNode.left = null;
            }
        }
        
        return min;
    }
}
