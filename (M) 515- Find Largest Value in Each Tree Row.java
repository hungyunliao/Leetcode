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
    public List<Integer> largestValues(TreeNode root) {
        /*
         Use BFS queue structure:
         find max in each row. Use thisGen and nextGen to identify which row in the tree.
         */
         
         Queue<TreeNode> qu = new LinkedList<>();
         List<Integer> ans = new LinkedList<>();
         int nextGen = 0, thisGen = 1, max = Integer.MIN_VALUE;
         
         if(root == null) {
             return ans;
         }
         
         qu.offer(root);
         
         while(thisGen != 0) {
             TreeNode currNode = qu.poll();
             nextGen += addChildren(qu, currNode);
             max = Math.max(max, currNode.val);
             if(--thisGen == 0) {
                 ans.add(max);
                 max = Integer.MIN_VALUE;
                 thisGen = nextGen;
                 nextGen = 0;
             }
         }
         
         return ans;
    }
    
    public int addChildren(Queue<TreeNode> queue, TreeNode node) {
        int numOfChildren = 0;
        if(node.left != null) {
            queue.offer(node.left);
            numOfChildren++;
        }
        if(node.right != null) {
            queue.offer(node.right);
            numOfChildren++;
        }
        return numOfChildren;
    }
}
