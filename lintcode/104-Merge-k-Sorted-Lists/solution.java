import java.util.*;

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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(10, new MyComparator());
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!queue.isEmpty()) {
            ListNode top = queue.remove();
            if (top.next != null) {
                queue.add(top.next);
            }
            curr.next = top;
            curr = curr.next;
            curr.next = null;
        }

        return dummy.next;
    }
    
    class MyComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode node1, ListNode node2) {
            return node1.val - node2.val;
        }
    }
}
