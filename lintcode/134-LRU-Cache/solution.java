public class Solution {

    // @param capacity, an integer
    public Solution(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new LRUNode();
        tail = new LRUNode();
        head.next = tail;
        tail.prev = head;
    }

    // @return an integer
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        LRUNode node = map.get(key);
        
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.prev = head;
        head.next.prev = node;
        node.next = head.next;
        head.next = node;

        return node.value;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // move node to head if exist
        if (map.containsKey(key)) {
            get(key);
            head.next.value = value;
            return;
        }

        if (capacity == map.size()) {
            map.remove(tail.prev.key);
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
        }

        LRUNode node = new LRUNode(key, value);
        map.put(key, node);

        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private int capacity;
    // head is the newest node
    private LRUNode head, tail;
    private Map<Integer, LRUNode> map;

    class LRUNode {
        int key;
        int value;
        LRUNode prev, next;
        LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
        LRUNode() {
            this.key = -1;
            this.value = -1;
            this.prev = null;
            this.next = null;
        }
    }
}