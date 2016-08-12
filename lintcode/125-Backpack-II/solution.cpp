class Solution {
public:
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    int backPackII(int m, vector<int> A, vector<int> V) {
        if (A.empty() || V.empty()) {
            return 0;
        }

        // dp[i][j] use ith to fill j size, the max value
        int n = A.size();
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                if (j < A[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = max(dp[i - 1][j], 
                        dp[i - 1][j - A[i - 1]] + V[i - 1]
                        );
                }
            }
        }

        return dp[n][m];
    }
};
