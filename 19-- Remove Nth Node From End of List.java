/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        } 
        
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        int index = 0;
        
        while (curr != null) {
            index++;
            list.add(curr);
            curr = curr.next;
        }
        
        index -= n;
        if (index == 0) {
            head = list.get(0).next;
        } else {
            curr = list.get(index - 1);
            curr.next = curr.next.next;
        }
        
        
        return head;
    }
}
