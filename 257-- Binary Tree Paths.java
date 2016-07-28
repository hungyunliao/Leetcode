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
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> list = new ArrayList<String>();
        if (root == null) return list;
        String str = "";
        helper(list, str, root);
        return list;
        
    }
    
    public void helper(List<String> list, String str, TreeNode root) {
        
        if (str != "") str += "->";
        str += root.val;
        
        if (root.left == null && root.right == null) {
            list.add(str);
        }
        
        if (root.left != null) helper(list, str, root.left);
        if (root.right != null) helper(list, str, root.right);
        
    }
}
