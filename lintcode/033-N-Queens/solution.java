class Solution {
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (n == 0) {
            return result;
        }
        
        int[][] board = new int[n][n];
        fillBoard(result, board, 0);
        
        return result;
    }
    
    void fillBoard(ArrayList<ArrayList<String>> result, int[][] board, int row) {
        if (row == board.length) {
            // add to result and return
            result.add(convertBoardToString(board));
            return;
        }
        
        for (int j = 0; j < board.length; ++j) {
            if (isValid(board, row, j)) {
                board[row][j] = 1;
                fillBoard(result, board, row + 1);
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
    
    ArrayList<String> convertBoardToString(int[][] board) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < board.length; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; ++j) {
                if (board[i][j] == 1) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            result.add(sb.toString());
        }
        
        return result;
    }
};