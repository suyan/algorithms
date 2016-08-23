/**
 * Definition for singly-linked list.
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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        // Note: k might larger than length of linked list
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }

        k = n % k;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            prev = prev.next;
        }

        // find the last kth prev node
        ListNode tail = dummy;
        while (prev.next != null) {
            ListNode next = prev.next.next;
            prev.next.next = tail.next;
            tail.next = prev.next;
            prev.next = next;
            tail = tail.next;
        }

        return dummy.next;
    }
}