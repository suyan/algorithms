public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        isFirstRowZero = true;
                    }
                    if (j == 0) {
                        isFirstColZero = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isFirstColZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (isFirstRowZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}