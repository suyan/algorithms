public class Solution {
    /**
     * @param stack an integer stack
     * @return void
     */
    public void stackSorting(Stack<Integer> stack) {
        Stack<Integer> helpStack = new Stack<>();

        while (!stack.empty()) {
            int smallest = stack.pop();
            while (!helpStack.empty() && helpStack.peek() < smallest) {
                stack.push(helpStack.pop());
            }

            helpStack.push(smallest);
        }

        while (!helpStack.empty()) {
            stack.push(helpStack.pop());
        }
    }
}