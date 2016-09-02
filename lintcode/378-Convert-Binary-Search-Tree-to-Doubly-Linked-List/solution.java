/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        if (root == null) {
            return null;
        }

        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode tail = dummy;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        
        while (!stack.empty()) {
            TreeNode top = stack.pop();
            tail.next = new DoublyListNode(top.val);
            tail.next.prev = tail;
            tail = tail.next;

            TreeNode right = top.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }

        return dummy.next;
    }
}
