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

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode curr = head;
        while (curr != null) {
            map.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            RandomListNode node = map.get(curr);
            node.next = map.get(curr.next);
            node.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}