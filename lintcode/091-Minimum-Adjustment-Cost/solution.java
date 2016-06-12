public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        if (A == null || A.size() == 0) {
            return -1;
        }
        
        // dp[i][j]: the min cost when ith element is adjusted to j
        int[][] dp = new int[A.size()][101];
        
        // dp[i][j] = abs(A[i] - j) + min(dp[i - 1][j] {abs(j - A[i]) <= target} )
        for (int i = 1; i < 101; i++) {
            dp[0][i] = Math.abs(i - A.get(0));
        }
        
        for (int i = 1; i < A.size(); i++) {
            for (int j = 1; j < 101; j++) {
                int cost = Math.abs(A.get(i) - j);
                int extra = Integer.MAX_VALUE;
                for (int k = 0; k <= target; k++) {
                    if (j + k <= 100) {
                        extra = Math.min(extra, dp[i - 1][j + k]);
                    }
                    if (j - k >= 1) {
                        extra = Math.min(extra, dp[i - 1][j - k]);
                    }
                }
                dp[i][j] = cost + extra;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < 101; i++) {
            min = Math.min(min, dp[A.size() - 1][i]);
        }
        
        return min;
    }
}