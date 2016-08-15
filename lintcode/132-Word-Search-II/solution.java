// DFS, time limited exceeded
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        HashSet<String> result = new HashSet<>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return new ArrayList<String>(result);
        }
        if (words.size() == 0) {
            return new ArrayList<String>(result);
        }

        int maxLength = 0;
        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
        }

        Set<String> dict = new HashSet(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWord(result, board, i, j, "", dict, maxLength);
            }
        }
        
        return new ArrayList<String>(result);
    }

    public void findWord(Set<String> result, char[][] board, int i, int j, String path, Set<String> dict, int maxLength) {
        // out of bound
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {
            return;
        }
        // visited before
        if (board[i][j] == '#') {
            return;
        }
        if (path.length() == maxLength + 1) {
            return;
        }
        // add current char in path
        path = path + board[i][j];
        board[i][j] = '#';
        if (dict.contains(path)) {
            result.add(path);
        }

        findWord(result, board, i + 1, j, path, dict, maxLength);
        findWord(result, board, i, j + 1, path, dict, maxLength);
        findWord(result, board, i - 1, j, path, dict, maxLength);
        findWord(result, board, i, j - 1, path, dict, maxLength);

        // backtracking
        board[i][j] = path.charAt(path.length() - 1);
        path = path.substring(0, path.length() - 1);
    }
}