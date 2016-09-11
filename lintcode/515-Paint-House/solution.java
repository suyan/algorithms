public class Solution {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] cost) {
        if (cost == null || cost.length == 0) return 0;
        int n = cost.length - 1;
        for (int i = 1; i <= n; i++) {
            cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
            cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
            cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);
        }
        return Math.min(cost[n][0], Math.min(cost[n][1], cost[n][2]));
    }
}