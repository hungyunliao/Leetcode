/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int diff = 0;
        ListNode head1 = l1;
        ListNode head2 = l2;
        while(head1 != null && head2 != null) {
            head1 = head1.next;
            head2 = head2.next;
        }
        while(head1 != null) {
            diff++;
            head1 = head1.next;
        }
        while(head2 != null) {
            diff--;
            head2 = head2.next;
        }
        head1 = (diff >= 0)? l1:l2; // head1 is the longer list
        head2 = (diff >= 0)? l2:l1; // head2 is the shorter list
        ListNode ans = new ListNode(0); // fake head
        ListNode head3 = ans;
        for(int i = 0; i < Math.abs(diff); i++) {
            head3.next = new ListNode(head1.val);
            head3 = head3.next;
            head1 = head1.next;
        }
        while(head1 != null && head2 != null) {
            int sum = head1.val + head2.val;
            head1 = head1.next;
            head2 = head2.next;
            head3.next = new ListNode(sum);
            head3 = head3.next;
        }
        head1 = (diff >= 0)? l1:l2;
        ans = reverseList(ans);
        head3 = ans;
        while(head3.next.next != null) {
            if(head3.val >= 10) {
                head3.next.val += 1;
                head3.val %= 10;
            }
            head3 = head3.next;
        }
        if(head3.val >= 10) {
            ListNode temp = head3.next;
            head3.next = new ListNode(1);
            head3.val %= 10;
            head3.next.next = temp;
        }
        
        return reverseList(ans).next;
    }
    
    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode T1 = null, T2 = null, T3 = null;
        T1 = head;
        if(head.next != null) {
            T2 = head.next;
        }
        if(head.next.next != null) {
            T3 = head.next.next;
        }
        T1.next = null;
        while(T2.next != null) {
            T3 = T2.next;
            T2.next = T1;
            T1 = T2;
            T2 = T3;
        }
        T2.next = T1;
        return T2;
    }
}
