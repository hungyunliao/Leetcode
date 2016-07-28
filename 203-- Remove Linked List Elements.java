/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null || (head.val == val && head.next == null )) { return null; }
        
        ListNode begin = new ListNode(0);
        begin.next = head;
        ListNode curr = begin;
        
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
                continue;
            }
            curr = curr.next;
        }
        
        return begin.next;
    }
}
