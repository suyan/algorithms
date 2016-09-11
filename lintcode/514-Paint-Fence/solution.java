public class Solution {
    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        if (n <= 0 || k <= 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        // dp[i]: total number of ways end with ith
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k * k;

        for (int i = 3; i <= n; i++) {
            // i is same as i - 1
            dp[i] += (k - 1) * dp[i - 1];
            // i is same as i - 2
            dp[i] += (k - 1) * dp[i - 2];
        }

        return dp[n];
    }
}