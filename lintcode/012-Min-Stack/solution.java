public class MinStack {
    
    private Deque<Integer> min;
    private Deque<Integer> stack;
    
    public MinStack() {
        stack = new ArrayDeque<Integer>();
        min = new ArrayDeque<Integer>();
    }

    public void push(int number) {
        if (stack.isEmpty()) {
            min.push(number);
        } else {
            if (min.peek() < number) {
                min.push(min.peek());
            } else {
                min.push(number);
            }
        }
        stack.push(number);
    }

    public int pop() {
        min.poll();
        return stack.poll();
    }

    public int min() {
        return min.peek();
    }
}
