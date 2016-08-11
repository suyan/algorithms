// use an increasing stack, O(n)
public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int len = height.length;
        int best = 0;

        for (int i = 0; i <= len; i++) {
            int curr = i == len ? -1 : height[i];
            while (!stack.empty() && curr <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.empty() ? i : i - stack.peek() - 1;
                best = Math.max(best, h * w);
            }
            stack.push(i);
        }

        return best;
    }
}
