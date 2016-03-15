import java.util.*;

public class LowestCommonAncestorofaBinarySearchTree {


		public static void main(String[] args) {
			TreeNode root = new TreeNode(3);
			TreeNode p = new TreeNode(3);
			p.right = new TreeNode(4);
			TreeNode q = new TreeNode(3);
		}
		
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        
            ArrayList<Integer> pAL = new ArrayList<Integer>();
	        ArrayList<Integer> qAL = new ArrayList<Integer>();
	        
	        helper(pAL, root, p);
	        helper(qAL, root, q);
	        int same = 0;
	        for (int i = 0; i < Math.min(pAL.size(), qAL.size()); i++) {
	            if (pAL.get(i) == qAL.get(i)) {
	                same = pAL.get(i);
	            }
	            else break;
	        }
	        
	        return new TreeNode(same);
	    }
	    
	    public ArrayList<Integer> helper(ArrayList<Integer> AL, TreeNode root, TreeNode x) {
	        AL.add(root.val);
	        if (x.val == root.val) {
	            return AL;
	        } else if (x.val > root.val) {
	            return helper(AL, root.right, x);
	        } else {
	            return helper(AL, root.left, x);
	        }
	    }
}
