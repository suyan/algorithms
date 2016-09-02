public class Solution {
    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = n - 1;
        int number = 1;
        // start point
        int x = 0;
        int y = 0;
        while (y >= left && y <= right && x >= up && x <= down) {
            // go right
            for (y = left; y <= right && x >= up; y++) {
                matrix[x][y] = number++;
            }
            y = right;
            up++;

            // go down
            for (x = up; x <= down && y >= left; x++) {
                matrix[x][y] = number++;
            }
            x = down;
            right--;

            // go left
            for (y = right; y >= left && x >= up; y--) {
                matrix[x][y] = number++;
            }
            y = left;
            down--;

            // go up
            for (x = down; x >= up && y <= right ; x--) {
                matrix[x][y] = number++;
            }
            left++;

            x = up;
            y = left;
        }

        return matrix;
    }
}