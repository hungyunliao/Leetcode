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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Implement a helper function. The input are two nodes.
        // Compare the values of two nodes, if they are differnt, false
        // To see whether they have children in same structure, e.g. both have only left child.
        // Use BFS
        
        // corner case:
        if(p == null) {
            if(q == null) return true;
            return false;
        } else if(q == null) {
            if(p == null) return true;
            return false;
        }
        
        Queue<TreeNode> qu1 = new LinkedList<>();
        Queue<TreeNode> qu2 = new LinkedList<>();
        qu1.add(p);
        qu2.add(q);
        while(qu1.size() != 0 && qu2.size() != 0) {
            TreeNode curr1 = qu1.poll();
            TreeNode curr2 = qu2.poll();
            if(!helper(curr1, curr2)) {
                return false;
            }
            if(curr1.left != null) qu1.add(curr1.left);
            if(curr1.right != null) qu1.add(curr1.right);
            if(curr2.left != null) qu2.add(curr2.left);
            if(curr2.right != null) qu2.add(curr2.right);
        }
        if(qu1.size() != 0 || qu2.size() != 0) {
            return false;
        }
        return true;
    }
    
    private boolean helper(TreeNode p, TreeNode q) {
        if(p.val != q.val) {
            return false;
        }
        if(p.left != null && q.left == null) {
            return false;
        }
        if(p.left == null && q.left != null) {
            return false;
        }
        if(p.right != null && q.right == null) {
            return false;
        }
        if(p.right == null && q.right != null) {
            return false;
        }
        return true;
    }
}
