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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;
        
        List<Integer> rootList = new ArrayList<>();
        
        helper(ans, rootList, root, sum);
        return ans;
    }
    
    private void helper(List<List<Integer>> gl, List<Integer> list,TreeNode node, int sum) {
        if(node.left == null && node.right == null) {
            if(sum - node.val == 0) {
                List<Integer> subAns = new ArrayList<Integer>(list);
                subAns.add(new Integer(node.val));
                gl.add(subAns);
            } 
            return;
        }
        list.add(new Integer(node.val));
        if(node.left != null) helper(gl, list, node.left, sum - node.val);
        if(node.right != null) helper(gl, list, node.right, sum - node.val);
        list.remove(list.size() - 1); // before returning from this node (two of its children are all visited, remove this node from the reference array.)
        return;
    }
}
