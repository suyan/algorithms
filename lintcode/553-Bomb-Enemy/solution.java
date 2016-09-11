public class Solution {
    /**
     * @param grid Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int result = 0;
        int rows = 0; // max value in current row
        int[] cols = new int[n]; // max value in cols
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // update rows because of W
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rows = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; ++k) {
                        if (grid[i][k] == 'E') {
                            rows += 1;
                        }
                    }
                }
                // update cols because of W
                if (i == 0 || grid[i - 1][j] == 'W') {
                    cols[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; ++k) {
                        if (grid[k][j] == 'E') {
                            cols[j] += 1;
                        }
                    }
                }

                if (grid[i][j] == '0' && rows + cols[j] > result) {
                    result = rows + cols[j];
                }
            }
        }

        return result;
    }
}