public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(0);

        int len = A.length;
        if (len == 0) {
            return result;
        }

        int[] presum = new int[len * 2 + 1];
        for (int i = 1; i < len * 2 + 1; i++) {
            presum[i] = presum[i - 1] + A[(i - 1) % len];
        }

        int minIndex = 0;
        int max = A[0];
        for (int i = 1; i <= len; i++) {
            if (presum[i] - presum[minIndex] > max) {
                max = presum[i] - presum[minIndex];
                result.set(0, minIndex);
                result.set(1, i - 1);
            }
            if (presum[i] <= presum[minIndex]) {
                minIndex = i;
            }
        }

        // use a min stack
        Stack<Integer> stack = new Stack<>();
        for (int i = len; i >= 1; --i) {
            if (stack.empty()) {
                stack.push(i);
            } else if (presum[i] < presum[stack.peek()]) {
                stack.push(i);
            } else {
                stack.push(stack.peek());
            }
        }

        for (int i = len + 1; i < 2 * len + 1; i++) {
            minIndex = stack.peek();
            stack.pop();
            if (presum[i] - presum[minIndex] > max) {
                max = presum[i] - presum[minIndex];
                result.set(1, (i - 1) % len);
                result.set(0, minIndex);
            }
        }

        return result;
    }
}