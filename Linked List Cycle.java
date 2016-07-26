/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if (head == null) {
            return false;
        }
        
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        
        while (!set.contains(curr)) {
            set.add(curr);
            if (curr.next == null) {
                return false;
            }
            curr = curr.next;
        }
        
        return true;
        
    }
}
