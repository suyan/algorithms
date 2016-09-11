public class Solution {
    /**
     * @param costs n x k cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int n = cost.length;
        int k = cost[0].length;

        int[][] dp = new int[n][k];
        for (int j = 0; j < k; j++) {
            dp[0][j] = cost[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                for (int t = 0; t < k; t++) {
                    if (t != j) {
                        min = Math.min(min, dp[i - 1][t]);
                    }
                }
                dp[i][j] = min + costs[i][j];
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            result = Math.min(result, dp[n - 1][j]);
        }

        return result;
    }
}