public class Solution {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }

        int row = A.length;
        int col = A[0].length;

        // dp[i][j]: the max length end with i
        int[][] dp = new int[row][col];
        boolean[][] visited = new boolean[row][col];

        int maxLength = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = findMaxLength(i, j, A, dp, visited);
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }

        return maxLength;
    }

    int findMaxLength(int x, int y, int[][] A, int[][] dp, boolean[][] visited) {
        if (visited[x][y] == true) {
            return dp[x][y];
        }

        int row = A.length;
        int col = A[0].length;
        int max = 1;
        int[] dx = {1, -1,  0,  0};
        int[] dy = {0,  0,  1, -1};
        int nx, ny;

        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (0 <= nx && nx < row && 0 <= ny && ny < col) {
                if (A[x][y] > A[nx][ny]) {
                    max = Math.max(max, findMaxLength(nx, ny, A, dp, visited) + 1);
                }
            }
        }

        visited[x][y] = true;
        dp[x][y] = max;

        return max;
    }
}