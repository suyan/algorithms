/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            int value = curr.val;
            if (curr.next.val == value) {
                // remove nodes have curent value
                while (prev.next != null && prev.next.val == value) {
                    prev.next = prev.next.next;
                }
            } else {
                prev = prev.next;
            }
            curr = prev.next;
        }

        return dummy.next;
    }
}
