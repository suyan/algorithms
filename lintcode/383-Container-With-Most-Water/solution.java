public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        int max = 0, amount;
        int start = 0;
        int end = heights.length - 1;
        while (start < end) {
            if (heights[start] > heights[end]) {
                amount = heights[end] * (end - start);
                end--;
            } else {
                amount = heights[start] * (end - start);
                start++;
            }
            max = Math.max(max, amount);
        }

        return max;
    }
}