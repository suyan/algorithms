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
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = head;

        while (prev.next != null) {
            ListNode curr = dummy;
            while (curr != prev && curr.next.val < prev.next.val) {
                curr = curr.next;
            }
            
            // note: do not move if current is the position
            if (curr == prev) {
                prev = prev.next;
                continue;
            }

            // insert prev.next to curr.next
            ListNode temp = prev.next;
            prev.next = prev.next.next;
            temp.next = curr.next;
            curr.next = temp;
        }

        return dummy.next;
    }
}