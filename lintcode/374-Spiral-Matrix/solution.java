public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        // start point
        int x = 0;
        int y = 0;
        while (y >= left && y <= right && x >= up && x <= down) {
            // go right
            for (y = left; y <= right && x >= up; y++) {
                result.add(matrix[x][y]);
            }
            y = right;
            up++;

            // go down
            for (x = up; x <= down && y >= left; x++) {
                result.add(matrix[x][y]);
            }
            x = down;
            right--;

            // go left
            for (y = right; y >= left && x >= up; y--) {
                result.add(matrix[x][y]);
            }
            y = left;
            down--;

            // go up
            for (x = down; x >= up && y <= right ; x--) {
                result.add(matrix[x][y]);
            }
            left++;

            x = up;
            y = left;
        }

        return result;
    }
}