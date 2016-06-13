/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        // create a dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = prev;
        while (curr.next != null) {
            if (curr.next.val < x) { // insert after index
                ListNode item = curr.next;
                curr.next = item.next;
                item.next = prev.next;
                prev.next = item;
                prev = prev.next;
                if (curr.next == prev) { // don't forget move curr when prev == curr
                    curr = curr.next;
                }
            } else {
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
}
