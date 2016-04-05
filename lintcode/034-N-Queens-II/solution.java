class Solution {
    
    private int count;
    
    public Solution() {
        count = 0;
    }

    public int totalNQueens(int n) {
        if (n == 0) {
            return count;
        }
        
        int[][] board = new int[n][n];
        fillBoard(board, 0);
        
        return count;
    }
    
    void fillBoard(int[][] board, int row) {
        if (row == board.length) {
            count++;
            return;
        }
        
        for (int j = 0; j < board.length; ++j) {
            if (isValid(board, row, j)) {
                board[row][j] = 1;
                fillBoard(board, row + 1);
                board[row][j] = 0;
            }
        }
    }
    
    private boolean isValid(int[][] board, int row, int column) {
        for (int i = 0; i < board.length; i++) {
            // check row
            if (board[row][i] == 1) {
                return false;
            }
            // check column
            if (board[i][column] == 1) {
                return false;
            }
            // check diagonal
            int delta = Math.abs(column - i);
            if (column - delta >= 0 && row - delta >= 0 
                && board[row-delta][column-delta] == 1) {
                return false;
            }
            if (column - delta >= 0 && row + delta < board.length
                && board[row+delta][column - delta] == 1) {
                return false;
            }
            if (column + delta < board.length && row - delta >= 0
                && board[row-delta][column + delta] == 1) {
                return false;
            }
            if (column + delta < board.length && row + delta < board.length
                && board[row+delta][column+delta] == 1) {
                return false;
            }
        }
        
        return true;
    }
};

