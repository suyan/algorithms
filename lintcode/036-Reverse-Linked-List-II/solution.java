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
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        // find prev node
        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }
        prev.next = reverseList(prev, n - m + 1);
        
        return dummy.next;
    }
 
    // return a list with reversed part   
    public ListNode reverseList(ListNode head, int k) {
        ListNode prev = null;
        ListNode first = head.next;
        for (int i = 0; i <= k; i++) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        first.next = head;
        
        return prev;
    }
}