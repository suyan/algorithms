public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        Set<String> result = new HashSet<>();
        Trie trie = new Trie(new TrieNode("", false));
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWord(result, board, i, j, trie.root);
            }
        }

        return new ArrayList<>(result);
    }

    private void findWord(Set<String> result, char[][] board, int i, int j, TrieNode root) {
        if (root.isWord) {
            result.add(root.prefix);
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (root.children.containsKey(board[i][j])) {
            char curr = board[i][j];
            board[i][j] = '#';
            findWord(result, board, i + 1, j, root.children.get(curr));
            findWord(result, board, i, j + 1, root.children.get(curr));
            findWord(result, board, i - 1, j, root.children.get(curr));
            findWord(result, board, i, j - 1, root.children.get(curr));
            board[i][j] = curr;
        }
    }

    private class Trie {
        TrieNode root;
        Trie(TrieNode root) {
            this.root = root;
        }

        void insert(String s) {
            TrieNode curr = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (curr.children.containsKey(c)) {
                    curr = curr.children.get(c);
                } else {
                    curr.children.put(c, new TrieNode(curr.prefix + c, false));
                    curr = curr.children.get(c);
                }
            }
            curr.isWord = true;
        }

        boolean search(String s) {
            TrieNode curr = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (curr.children.containsKey(c)) {
                    curr = curr.children.get(c);
                } else {
                    return false;
                }
            }
            return curr.isWord;
        }
    }

    private class TrieNode {
        String prefix;
        boolean isWord;
        Map<Character, TrieNode> children;
        TrieNode(String prefix, boolean isWord) {
            this.children = new HashMap<>();
            this.prefix = prefix;
            this.isWord = isWord;
        }
    }
}