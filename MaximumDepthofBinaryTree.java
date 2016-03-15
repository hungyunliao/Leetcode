import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 
public class MaximumDepthofBinaryTree {
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(3);
		root.left.left.left.right = new TreeNode(3);
		root.right = root.left;
		
		System.out.println(root.right.val);
	}
	
	
	public static int maxDepth(TreeNode root) {
        if (root == null) { return 0; }
        int left = 0;
        int right = 0;
        left = maxDepth(root.left);
        right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
    
}
