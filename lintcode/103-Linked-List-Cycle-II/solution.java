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
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // find cycle first
        ListNode slow = head;
        ListNode fast = head;

        boolean hasCycle = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle == false) {
            return null;
        }

        // cut cycle
        ListNode head1 = slow.next;
        slow.next = null;

        // reverse linked list
        ListNode head2 = reverse(head);

        // find intersection of two linked lists
        ListNode result = findIntersection(head1, head2);
        
        // reverse to original list
        reverse(head2);
        head2.next = head1;
        
        return result;
    }

    private ListNode findIntersection(ListNode list1, ListNode list2) {
        int len1 = 0;
        ListNode curr = list1;
        while (curr != null) {
            len1++;
            curr = curr.next;
        }

        int len2 = 0;
        curr = list2;
        while (curr != null) {
            len2++;
            curr = curr.next;
        }

        // let list1 and list2 have same length
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                list1 = list1.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                list2 = list2.next;
            }
        }

        // go together
        while (list1 != null && list2 != null) {
            if (list1 == list2) {
                return list1;
            }
            list1 = list1.next;
            list2 = list2.next;
        }

        return null;
    }

    private ListNode reverse(ListNode head) {
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
}
