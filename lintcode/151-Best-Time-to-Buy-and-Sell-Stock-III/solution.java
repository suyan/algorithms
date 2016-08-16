class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int minimum = prices[0];

        // when sell before ith day and buy from start, the max profit
        int[] forwardProfit = new int[len];
        for (int i = 1; i < len; i++) {
            forwardProfit[i] = Math.max(forwardProfit[i - 1], prices[i] - minimum);
            minimum = Math.min(minimum, prices[i]);
        }

        // when buy after ith day and sell before last day, the max profit
        int[] backwardProfit = new int[len];
        int maximum = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            backwardProfit[i] = Math.max(backwardProfit[i + 1], maximum - prices[i]);
            maximum = Math.max(maximum, prices[i]);
        }

        int maxProfit = forwardProfit[len - 1]; // one transaction
        for (int i = 1; i < len; i++) {
            maxProfit = Math.max(maxProfit, forwardProfit[i - 1] + backwardProfit[i]);
        }

        return maxProfit;
    }
}