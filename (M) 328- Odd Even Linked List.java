/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
       if(head == null || head.next == null) {
           return head;
       }
       
       ListNode oddHead = head;
       ListNode evenHead = head.next;
       ListNode nnNode = null;
       ListNode nNode = null;
       boolean isLinkedOdd = true;
       
       while(head.next.next != null) {
           nNode = head.next;
           nnNode = head.next.next;
           head.next = nnNode;
           head = nNode;
           isLinkedOdd = !isLinkedOdd;
       }
       
       if(isLinkedOdd) {
           head.next = evenHead;
       } else {
           head.next.next = evenHead;
           head.next = null;
       }
       
       return oddHead;
       
    }
}
