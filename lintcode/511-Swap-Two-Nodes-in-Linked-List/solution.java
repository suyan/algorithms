/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        if (head == null || head.next == null || v1 == v2) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev1 = dummy;
        ListNode prev2 = dummy;
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == v1) {
                prev1 = curr;
            }
            if (curr.next.val == v2) {
                prev2 = curr;
            }
            curr = curr.next;
        }

        if (prev1.next.val != v1 || prev2.next.val != v2) {
            return head;
        }

        if (prev1.val == v2) {
            prev2.next = prev1.next;
            prev1.next = prev1.next.next;
            prev2.next.next = prev1;
            return dummy.next;
        }
        if (prev2.val == v1) {
            prev1.next = prev2.next;
            prev2.next = prev2.next.next;
            prev1.next.next = prev2;
            return dummy.next;
        }

        ListNode node1 = prev1.next;
        ListNode node2 = prev2.next;
        prev1.next = node1.next;
        prev2.next = node2.next;

        node1.next = prev2.next;
        prev2.next = node1;

        node2.next = prev1.next;
        prev1.next = node2;

        return dummy.next;
    }
}