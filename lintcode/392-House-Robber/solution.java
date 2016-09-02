public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        if (A.length == 0) return 0;
        if (A.length == 1) return A[0];

        // rob to ith house maxmium
        long[] dp = new long[3];
        dp[0] = A[0];
        dp[1] = Math.max(A[0], A[1]);

        // dp(i) = max(dp(i - 1), dp(i - 2) + A[i]);
        for (int i = 2; i < A.length; i++) {
            dp[i % 3] = Math.max(dp[(i - 1) % 3], dp[(i - 2) % 3] + A[i]);
        }
        
        return dp[(A.length - 1) % 3];
    }
}