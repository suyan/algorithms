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
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        if (head == null || head.next == null) {
            return;
        }
        
        // cut linked list into two parts
        ListNode prev = findPreviousOfMiddle(head);
        ListNode second = prev.next;
        prev.next = null;

        // reverse second part
        second = reverseList(second);

        // merge two lists
        head = mergeTwoLists(head, second);
    }

    private ListNode findPreviousOfMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = prev.next;
            fast = fast.next.next;
        }
        return prev;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (head1 != null && head2 != null) {
            curr.next = head1;
            head1 = head1.next;
            curr = curr.next;
            curr.next = head2;
            head2 = head2.next;
            curr = curr.next;
            curr.next = null;
        }

        if (head1 != null) {
            curr.next = head1;
        }

        if (head2 != null) {
            curr.next = head2;
        }

        return dummy.next;
    }
}
