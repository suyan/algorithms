public class Solution {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] height = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    height[i][j] = ((matrix[i][j] == true) ? 1 : 0);
                } else {
                    height[i][j] += ((matrix[i][j] == true) ? height[i - 1][j] + 1 : 0);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < m; j++) {
                while (!stack.empty() && height[i][j] < height[i][stack.peek()]) {
                    int pos = stack.pop();
                    result = Math.max(result, height[i][pos] * (stack.empty() ? j : j - stack.peek() - 1));
                }
                stack.push(j);
            }
            while (!stack.empty()) {
                int pos = stack.pop();
                result = Math.max(result, height[i][pos] * (stack.empty() ? m : m - stack.peek() - 1));
            }
        }

        return result;
    }
}