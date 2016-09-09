public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        int side = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return side;
        }

        // dp[i][j]: the max square from 0,0 to i,j
        // dp[i][j]: 0 if matrix[i][j] = 0
        // dp[i][j]: min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1 if matrix[i][j] = 1
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            side = Math.max(side, matrix[i][0]);
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i- 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    side = Math.max(dp[i][j], side);
                }
            }
        }

        return side * side;
    }
}