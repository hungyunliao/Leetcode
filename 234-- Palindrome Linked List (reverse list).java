/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) { return true; }
        
        /*  Algo:
            1. fast goes straight to the end of the list, and the slow stops at the middle of the list.
            2. reverse the list after slow.
            3. compare the fast.val with head.val one by one. If they are different, return false.
        */
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        /* If List contains odd element, needs to move fast and slow forward. */
        if (fast.next != null) {
            fast = fast.next;
            ListNode next = slow.next;
            slow.next = null;
            slow = next;
        }
        
        reverse(slow, null);
        
        while (head != fast || (head != null && fast != null)) {
            if (head.val != fast.val) { return false; }
            head = head.next;
            fast = fast.next;
        }
        
        return true;
    }
    
    public void reverse(ListNode head, ListNode prev) {
        if (head.next == null) {
            head.next = prev;
            return;
        }
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
        reverse(head, prev);
    }
}
