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
        // distance from start to cuurent node
        Map<String, Integer> distance = new HashMap<>();

        dict.add(start);
        dict.add(end);

        bfs(map, distance, start, end, dict);

        List<String> path = new ArrayList<>();
        dfs(result, map, distance, path, end, start);

        return result;
    }

    public void dfs(List<List<String>> result,
                    Map<String, List<String>> map,
                    Map<String, Integer> distance,
                    List<String> path,
                    String curr,
                    String start) {
        path.add(curr);
        if (curr.equals(start)) {
            List<String> newPath = new ArrayList<>(path);
            Collections.reverse(newPath);
            result.add(newPath);
        } else {
            for (String child : map.get(curr)) {
                if (distance.get(curr) == distance.get(child) + 1) {
                    dfs(result, map, distance, path, child, start);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    public void bfs(Map<String, List<String>> map,
                    Map<String, Integer> distance,
                    String start,
                    String end,
                    Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        distance.put(start, 0);
        for (String word : dict) {
            map.put(word, new ArrayList<String>());
        }

        while (!queue.isEmpty()) {
            String curr = queue.remove();
            for (String child : getChildren(curr, dict)) {
                map.get(curr).add(child);
                if (!distance.containsKey(child)) {
                    distance.put(child, distance.get(curr) + 1);
                    queue.add(child);
                }
            }
        }
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