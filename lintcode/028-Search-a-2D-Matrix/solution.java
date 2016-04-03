// binary search solution O(logn + logm)
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // binary searh in column
        int begin = 0;
        int end = matrix.length - 1;
        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;
            if (target < matrix[mid][0]) {
                end = mid;
            } else {
                begin = mid;
            }
        }

        int row = 0;
        if (target >= matrix[end][0]) {
            row = end;
        } else if (target >= matrix[begin][0]) {
            row = begin;
        } else {
            return false;
        }

        // binary search in row
        begin = 0;
        end = matrix[row].length - 1;
        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;
            if (target < matrix[row][mid]) {
                end = mid;
            } else {
                begin = mid;
            }
        }

        if (target == matrix[row][begin]) {
            return true;
        } else if (target == matrix[row][end]) {
            return true;
        } else {
            return false;
        }
    }
}
