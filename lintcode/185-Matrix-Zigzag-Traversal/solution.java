public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int count = m * n;
        int[] result = new int[count];
        int r = 0, c = 0;
        result[0] = matrix[0][0];

        for (int i = 1; i < count;) {
            // go right and up
            while (i < count && r - 1 >= 0 && c + 1 < n) {
                result[i++] = matrix[--r][++c];
            }
            // go right or go right and down
            if (i < count && c + 1 < n) {
                result[i++] = matrix[r][++c];
            } else if (i < count && r + 1 < m) {
                result[i++] = matrix[++r][c];
            }
            // go left and down
            while (i < count && r + 1 < m && c - 1 >= 0) {
                result[i++] = matrix[++r][--c];
            }
            // go down or go right
            if (i < count && r + 1 < m) {
                result[i++] = matrix[++r][c];
            } else if (i < count && c + 1 < n) {
                result[i++] = matrix[r][++c];
            }
        }
        return result;
    }
}
