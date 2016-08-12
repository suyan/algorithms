class Solution {
public:
    bool exist(vector<vector<char> > &board, string word) {
        if (board.size() == 0 || board[0].size() == 0) return false;
        if (word.size() == 0) return true;
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size(); j++) {
                if (board[i][j] == word[0]) {
                    if (search(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
private:
    bool search(vector<vector<char>> &board, int i, int j, string word, int start) {
        if (start == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size() || board[i][j] != word[start]) {
            return false;
        }

        board[i][j] = '#';
        bool rst = search(board, i-1, j, word, start+1) || search(board, i, j-1, word, start+1) || search(board, i+1, j, word, start+1) || search(board, i, j+1, word, start+1);
        board[i][j] = word[start];

        return rst;
    }
};
