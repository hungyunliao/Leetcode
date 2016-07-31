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
        
        ListNode length = head;
        ListNode curr = head;
        int leng = 0;
        int step = 0;
        String leftStr = "";
        String rightStr = "";
        
        while (curr != null) {
            if (length != null) {
                
                length = length.next;
                step++;
                if (step == 2) {
                    leftStr += curr.val;
                    curr = curr.next;
                    step = 0;
                }
            } else {
                if (step == 1) {
                    step++;
                    curr = curr.next;
                    continue;
                }
                
                String temp = "";
                temp += curr.val;
                rightStr = temp + rightStr;
                curr = curr.next;
                
            }
        }
        return leftStr.equals(rightStr)? true: false;
    }
}
