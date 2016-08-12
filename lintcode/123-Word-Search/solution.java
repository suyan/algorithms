public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && findWord(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    private boolean findWord(char[][] board, boolean[][] visited, int i, int j, String word, int pos) {
        if (pos == word.length()) {
            return true;
        }

        if (i == board.length || i < 0 || j == board[0].length || j < 0 || board[i][j] != word.charAt(pos)) {
            return false;
        }

        if (visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        if (findWord(board, visited, i + 1, j, word, pos + 1) || findWord(board, visited, i, j + 1, word, pos + 1)
            || findWord(board, visited, i -1, j, word, pos + 1) || findWord(board, visited, i, j - 1, word, pos + 1)) {
            return true;
        }
        visited[i][j] = false;

        return false;
    }
}