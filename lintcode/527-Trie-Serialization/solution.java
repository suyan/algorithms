/**
 * Definition of TrieNode:
 * public class TrieNode {
 *     public NavigableMap<Character, TrieNode> children;
 *     public TrieNode() {
 *         children = new TreeMap<Character, TrieNode>();
 *     }
 * }
 */
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a trie which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TrieNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);

        return sb.toString();
    }

    public void serialize(TrieNode root, StringBuilder sb) {
        sb.append("<");
        for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
            sb.append(entry.getKey());
            serialize(entry.getValue(), sb);
        }
        sb.append(">");
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TrieNode deserialize(String data) {
        TrieNode root = new TrieNode();
        StringBuilder sb = new StringBuilder(data);
        deserialize(root, sb);
        
        return root;
    }

    public void deserialize(TrieNode root, StringBuilder sb) {
        // remove < from sb
        sb.deleteCharAt(0);
        
        while (sb.charAt(0) != '>') {
            TrieNode node = new TrieNode();
            root.children.put(sb.charAt(0), node);
            sb.deleteCharAt(0);
            deserialize(node, sb);
        }

        // remove > from sb
        sb.deleteCharAt(0);
    }
}
