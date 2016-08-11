// search with target level: time excceeded 
public class Solution {
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<>();
        if (start == null || end == null) {
            return result;
        }

        // graph nodes
        Map<String, List<String>> map = new HashMap<>();

        dict.add(start);
        dict.add(end);

        int level = bfs(map, start, end, dict);

        List<String> path = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        visited.add(end);
        dfs(result, map, path, visited, end, start, 0, level);

        return result;
    }

    public void dfs(List<List<String>> result, Map<String, List<String>> map,
                    List<String> path, Set<String> visited,
                    String curr, String end,
                    int currentLevel, int target) {
        if (currentLevel == target) {
            if (curr.equals(end)) {
                path.add(curr);
                List<String> newPath = new ArrayList<>(path);
                Collections.reverse(newPath);
                result.add(newPath);
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(curr);
        visited.add(curr);
        for (String child : map.get(curr)) {
            if (visited.contains(child)) {
                continue;
            }
            dfs(result, map, path, visited, child, end, currentLevel + 1, target);
        }
        visited.remove(curr);
        path.remove(path.size() - 1);
    }

    public int bfs(Map<String, List<String>> map, String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        map.put(start, new ArrayList<String>());

        int level = 0;

        boolean touchEnd = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.remove();
                if (curr.equals(end)) { // once touch end, stop in this level
                    touchEnd = true;
                }
                for (String child : getChildren(curr, dict)) {
                    if (!map.containsKey(child)) {
                        map.put(child, new ArrayList<String>());
                    }
                    map.get(curr).add(child);
                    if (visited.contains(child)) {
                        continue;
                    }
                    queue.add(child);
                    visited.add(child);
                }
            }
            if (touchEnd) {
                break;
            }
            level++;
        }

        return level;
    }

    public List<String> getChildren(String word, Set<String> dict) {
        List<String> children = new ArrayList<>();
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < sb.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                sb.setCharAt(i, c);
                if (dict.contains(sb.toString())) {
                    children.add(sb.toString());
                }
            }
            sb.setCharAt(i, word.charAt(i));
        }

        return children;
    }
}