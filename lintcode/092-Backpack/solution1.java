public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // dp[i][k]: if we can fill k with the elements before i
        // dp[i][k] = dp[i - 1][k] || dp[i - 1][k - A[i]]
        boolean[][] dp = new boolean[A.length][m + 1];
        
        dp[0][0] = true;
        if (m >= A[0])
            dp[0][A[0]] = true;
        
        int max = 0;
        for (int i = 1; i < A.length; i++) {
            for (int k = 0; k < m + 1; k++) {
                dp[i][k] = dp[i - 1][k] || (k >= A[i] && dp[i - 1][k - A[i]]);
                if (dp[i][k] == true) {
                    max = Math.max(max, k);
                }
            }
        }
        
        return max;
    }
}