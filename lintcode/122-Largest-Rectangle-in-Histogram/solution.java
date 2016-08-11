// Brute force, O(n^n)
public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxSize = 0;
        for (int i = 0; i < height.length; i++) {
            int sum = expend(i, height);
            maxSize = Math.max(maxSize, sum);
        }

        return maxSize;
    }

    private int expend(int index, int[] height) {
        int sum = height[index];
        for (int i = index - 1; i >= 0 && height[i] >= height[index]; i--) {
            sum += height[i];
        }

        for (int i = index + 1; i < height.length && height[i] >= height[index]; i++) {
            sum += height[i];
        }

        return sum;
    }
}
