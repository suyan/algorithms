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
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        for (int i = 1; i < n; i++) {
            if (curr == null) {
                return null;
            }
            curr = curr.next;
        }

        ListNode target = head;
        while (curr.next != null) {
            curr = curr.next;
            target = target.next;
        }

        return target;
    }
}
