class Solution {
    /**
      * @param board: the board
      * @return: wether the Sudoku is valid
      */
    public boolean isValidSudoku(char[][] board) {
        // check row
        int len = board.length;
        for (int i = 0; i < len; i++) {
            if (hasDuplicate(board, i, i + 1, 0, len, len)) {
                return false;
            }
        }

        // check column
        for (int j = 0; j < len; j++) {
            if (hasDuplicate(board, 0, len, j, j + 1, len)) {
                return false;
            }
        }

        // check square
        int size = (int) Math.sqrt(len);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (hasDuplicate(board, size * i, size * (i + 1), size * j, size * (j + 1), len)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean hasDuplicate(char[][] board, int startRow, int endRow, int startCol, int endCol, int size) {
        boolean[] visited = new boolean[size + 1];
        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (board[i][j] != '.') {
                    if (visited[board[i][j] - '0']) {
                        return true;
                    }
                    visited[board[i][j] - '0'] = true;
                }
               
            }
        }

        return false;
    }
}