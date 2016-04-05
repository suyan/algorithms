// time complexity O(m + n)
public class Solution {
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length - 1;
        int column = 0;
        int count = 0;

        while (row >= 0 && column < matrix[0].length) {
            if (matrix[row][column] > target) {
                row--;
            } else if (matrix[row][column] < target) {
                column++;
            } else {
                count++;
                column++;
                row--;
            }
        }
        
        return count;
    }
}