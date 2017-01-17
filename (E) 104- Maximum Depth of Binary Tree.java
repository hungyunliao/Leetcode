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
    public int maxDepth(TreeNode root) {
        // use DFS search
        // use stack, push right first, then push left
        // var count, max to get the max path
        
        // corner case:
        if(root == null) {
            return 0;
        }
        
        int count = 0, max = 0;
        Stack<TreeNode> sk = new Stack<>();
        Stack<Integer> value = new Stack<>();   // record the depth
        sk.push(root);
        value.push(1);
        
        while(!sk.empty()) {
            TreeNode curr = sk.pop();
            int depth = value.pop();
            
            if(curr.left == null && curr.right == null) {
                max = Math.max(max, depth);
                continue;
            }
            if(curr.right != null) {
                sk.push(curr.right);
                value.push(depth + 1);
            } 
            if(curr.left != null) {
                sk.push(curr.left);
                value.push(depth + 1);
            }
        }
        return max;
    }
}
