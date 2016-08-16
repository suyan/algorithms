class Solution {
public:
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    int maxProfit(vector<int> &prices) {
        if (prices.size() == 0) {
            return 0;
        }
        
        int min_price = INT_MAX;
        int profit = 0;
        for (int price : prices) {
            min_price = min(min_price, price);
            profit = max(profit, price - min_price);
        }

        return profit;
    }
};

