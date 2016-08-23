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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        int carry = 0;
        while (l1 != null && l2 != null) {
            int result = l1.val + l2.val + carry;
            carry = result / 10;
            curr.next = new ListNode(result % 10);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int result = l1.val + carry;
            carry = result / 10;
            curr.next = new ListNode(result % 10);
            curr = curr.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int result = l2.val + carry;
            carry = result / 10;
            curr.next = new ListNode(result % 10);
            curr = curr.next;
            l2 = l2.next;
        }

        // pay attention to last carry
        if (carry != 0) {
            curr.next = new ListNode(carry);
            curr = curr.next;
        }

        return dummy.next;
    }
}