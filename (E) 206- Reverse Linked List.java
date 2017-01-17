/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        // Create 3 pointers, h1, h2, h3 pointing to head, head.next, head.next.next repectively
        // h2.next = h1;
        // h1 = h3;
        // head.next = null;
        
        // corner case:
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode h1 = head, h2 = h1.next, h3 = h2.next;
        h1.next = null;
        while(h3 != null) {
            h2.next = h1;
            h1 = h2;
            h2 = h3;
            h3 = h2.next;
        }
        h2.next = h1;
        return h2;
    }
}
