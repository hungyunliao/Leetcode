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
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        TreeNode curr;
        qu.add(root);
        int number = 0;
        while(qu.size() != 0) {
            number++;
            curr = qu.poll();
            TreeNode left = curr.left;
            TreeNode right = curr.right;
            if(left != null) qu.add(left);
            if(right != null) qu.add(right);
        }
        return number;
    }
}
