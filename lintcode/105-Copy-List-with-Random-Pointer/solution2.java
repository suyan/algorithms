/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        // create new node and insert after original node
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode node = new RandomListNode(curr.label);
            node.next = curr.next;
            curr.next = node;
            curr = node.next;
        }

        // copy random pointer
        curr = head;
        while (curr != null) {
            if (curr.random == null) {
                curr.next.random = null;
            } else {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // extract new list
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode newCurr = dummy;
        curr = head;
        while (curr != null) {
            newCurr.next = curr.next;
            curr.next = curr.next.next;
            newCurr = newCurr.next;
            newCurr.next = null;
            curr = curr.next;
        }

        return dummy.next;
    }
}