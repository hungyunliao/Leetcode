/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode curr = head;
        ListNode previous = head;
        head = head.next;
        
        while (curr.next != null) {
            previous.next = curr.next;
            previous = curr;
            ListNode third = curr.next.next;
            curr.next.next = curr;
            curr.next = third;
            if (curr.next != null) { curr = curr.next; }
            else { break; }
        }
        
        return head;
    }
}
