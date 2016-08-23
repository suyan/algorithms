public class Solution {
    /**
     * @param nums a list of integer
     * @return an integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        // dp[i][j]: the max value when burst i -> j baloons
        // dp[i][j] = max(dp[i][j], num[i - 1] * num[k] * num[j + 1] + dp[left][k - 1] + dp[k + 1][right])

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                for (int k = left; k <= right; k++) {
                    dp[left][right] = Math.max(
                        dp[left][right],
                        newNums[left - 1] * newNums[k] * newNums[right + 1] + dp[left][k - 1] + dp[k + 1][right]);
                }
            }
        }

        return dp[1][n];
    }
}
