class Node {
    public int val;
    public Node next;
    public Node(int _val) {
        val = _val;
        next = null;
    }
}

public class Queue {
    public Node first, last;
    
    public Queue() {
        first = last = null;
        // do initialize if necessary
    }

    public void enqueue(int item) {
        // Write your code here
        if (first == null) {
            last = new Node(item);
            first = last;       
        } else {
            last.next = new Node(item);
            last = last.next;
        }
    }

    public int dequeue() {
        // Write your code here
        if (first != null) {
            int item = first.val;
            first = first.next;
            return item;
        }
        return -1;
    }
}