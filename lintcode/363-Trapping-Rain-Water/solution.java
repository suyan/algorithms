public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxHeight = 0, maxIndex = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                maxIndex = i;
            }
        }

        int result = 0;
        maxHeight = 0;
        // from left to maxIndex
        for (int i = 0; i < maxIndex; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
            } else {
                result += maxHeight - heights[i];
            }
        }

        maxHeight = 0;
        // from right to maxIndex
        for (int i = heights.length - 1; i > maxIndex; i--) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
            } else {
                result += maxHeight - heights[i];
            }
        }

        return result;
    }
}