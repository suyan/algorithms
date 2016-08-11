public class Solution {
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null || start.length() != end.length()) {
            return -1;
        }
        if (start.equals(end)) {
            return 1;
        }
        if (dict.size() == 0) {
            return -1;
        }

        // don't forget add end to dict
        dict.add(end);

        // use bfs to traverse all words
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int length = 1;
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String curr = queue.remove();
                if (curr.equals(end)) {
                    return length;
                } else {
                    List<String> children = getChildren(curr, dict, visited);
                    for (String child : children) {
                        queue.add(child);
                        visited.add(child);
                    }
                }
                size--;
            }
            length++;
        }

        return -1;
    }

    public List<String> getChildren(String word, Set<String> dict, Set<String> visited) {
        List<String> children = new ArrayList<>();
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < sb.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                sb.setCharAt(i, c);
                if (dict.contains(sb.toString()) && !visited.contains(sb.toString())) {
                    children.add(sb.toString());
                }
            }
            sb.setCharAt(i, word.charAt(i));
        }

        return children;
    }
}