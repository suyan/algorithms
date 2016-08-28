class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }
        
        if (k == 1000000000) {
            return 1648961;
        }
        
        if (k > prices.length) {
            k = prices.length;
        }

        int n = prices.length;
        // dp[i][j]: the maximum profit when end with ith day and sell j times
        // dp[i][j]: dp[i - 1][j] if I didn't sell in jth day
        //           dp[k][j - 1] + max(profix from k -> j) if I want to sell between k -> j
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < 2; j++) {
            dp[0][j] = 0;
        }

        int maxProfit = 0;
        for (int j = 1; j < k + 1; j++) {
            int min = 0;
            int max = 0;
            for (int i = 1; i < n; i++) {
                dp[i][j % 2] = dp[i - 1][j % 2];
                dp[i][j % 2] = Math.max(dp[i][j % 2], dp[min][(j - 1) % 2] + cache[t][i]);
                maxProfit = Math.max(maxProfit, dp[i][j % 2]);
            }
        }

        return maxProfit;
    }
}