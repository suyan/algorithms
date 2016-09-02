class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int days = prices.length;

        if (days <= k) {
            return maxProfit2(prices);
        }

        // local[i][j]: j times in i days, but must sell in i
        int[][] local = new int[days][k + 1];
        // global[i][j]: j times in i days, but do not need sell in i
        int[][] global = new int[days][k + 1];

        for (int i = 1; i < days; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(
                    // sell at today with max profix before
                    global[i - 1][j - 1] + diff, 
                    // sell at today and just extend the profix yesterday
                    local[i - 1][j] + diff);
                global[i][j] = Math.max(
                    // do not sell today
                    global[i - 1][j], 
                    // sell today
                    local[i][j]);
            }
        }

        return global[days - 1][k];
    }

    int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}