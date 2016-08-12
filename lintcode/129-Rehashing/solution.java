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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length == 0) {
            return hashTable;
        }
        
        ListNode[] newHashTable = new ListNode[hashTable.length * 2];

        int len = hashTable.length;
        for (int i = 0; i < len; i++) {
            if (hashTable[i] == null) {
                continue;
            }
            // move current list's nodes to new position
            ListNode dummy = new ListNode(0);
            dummy.next = hashTable[i];
            ListNode prev = dummy;
            ListNode curr = dummy.next;
            while (curr != null) {
                int newKey = hashKey(curr.val, len * 2);
                if (newKey != i) {
                    prev.next = curr.next;
                    if (newHashTable[newKey] == null) {
                        newHashTable[newKey] = curr;
                        curr.next = null;
                    } else {
                        ListNode tail = newHashTable[newKey];
                        while (tail.next != null) {
                            tail = tail.next;
                        }
                        tail.next = curr;
                        curr.next = null;
                    }
                    curr = prev.next;
                } else {
                    prev = prev.next;
                    curr = curr.next;
                }
            }
            newHashTable[i] = dummy.next;
        }
        
        return newHashTable;
    }
    
    private int hashKey(int key, int tableSize) {
        return (key % tableSize + tableSize) % tableSize;
    }
}
