public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length; // rows
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        dp[rows - 1][cols - 1] = grid[rows - 1][cols - 1];

        for (int i = rows - 2; i >= 0; i--) {
            dp[i][cols - 1] = dp[i + 1][cols - 1] + grid[i][cols - 1];
        }
        for (int j = cols - 2; j >= 0; j--) {
            dp[rows - 1][j] = dp[rows - 1][j + 1] + grid[rows - 1][j];
        }
        

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        return dp[0][0];
    }
}
