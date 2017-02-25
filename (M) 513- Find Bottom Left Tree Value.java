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
    public int findBottomLeftValue(TreeNode root) {
        
        /*
            Use BFS:
            thisGen records the number of nodes in this row; nextGen records the number of nodes in next row
            when thisGen == 0, which means the next row is about to begin, so record the first node value (leftmost node in the next row). Break if nextGen is zero.
        
        */
        
        
        Queue<TreeNode> qu = new LinkedList<>();
        if(root.left == null && root.right == null) {
            return root.val;
        }
        int thisGen = 1, nextGen = 0, left = 0;
        
        qu.offer(root);
        while(thisGen != 0) {
          TreeNode currNode = qu.poll();
          if(currNode.left != null) {
              qu.offer(currNode.left);
              nextGen++;
          }
          if(currNode.right != null) {
              qu.offer(currNode.right);
              nextGen++;
          }
          if(--thisGen == 0) {
              if(nextGen == 0) {
                  break;
              }
              left = qu.peek().val;
              thisGen = nextGen;
              nextGen = 0;
          }
          
        }
        
        return left;
    }
}
