class Node {
    public int val;
    public Node next, prev;
    public Node(int _val) {
        val = _val;
        prev = next = null;
    }
}

public class Dequeue {
    public Node first, last;
    
    public Dequeue() {
        first = last = null;
        // do initialize if necessary
    }

    public void push_front(int item) {
        // Write your code here
        if (first == null) {
            last = new Node(item);
            first = last;       
        } else {
            Node tmp = new Node(item);
            first.prev = tmp;
            tmp.next = first;
            first = first.prev;
        }
    }

    public void push_back(int item) {
        // Write your code here
        if (last == null) {
            last = new Node(item);
            first = last;       
        } else {
            Node tmp = new Node(item);
            last.next = tmp;
            tmp.prev = last;
            last = last.next;
        }
    }

    public int pop_front() {
        // Write your code here
        if (first != null) {
            int item = first.val;
            first = first.next;
            if (first != null)
                first.prev = null;
            else
                last = null;
            return item;
        }
        return -11;
    }

    public int pop_back() {
        // Write your code here
        if (last != null) {
            int item = last.val;
            last = last.prev;
            if (last != null)
                last.next = null;
            else
                first = null;
            return item;
        }
        return -11;
    }
}