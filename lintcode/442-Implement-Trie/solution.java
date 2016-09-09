/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    char c;
    boolean isWord;
    TrieNode[] children;
    // Initialize your data structure here.
    public TrieNode() {
        c = '0';
        isWord = false;
        children = new TrieNode[26];
    }

    public TrieNode(char c) {
        this.c = c;
        isWord = false;
        children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        TrieNode curr = root;
        int index = 0;
        while (index < word.length()) {
            char c = word.charAt(index);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode(c);
            }
            curr = curr.children[c - 'a'];
            index++;
        }

        curr.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        TrieNode curr = root;
        int index = 0;
        while (index < word.length()) {
            char c = word.charAt(index);
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
            index++;
        }

        return curr.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (word == null || word.length() == 0) {
            return false;
        }

        TrieNode curr = root;
        int index = 0;
        while (index < word.length()) {
            char c = word.charAt(index);
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
            index++;
        }

        return true;
    }
}