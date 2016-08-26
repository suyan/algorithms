public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // corner case for only one node
        if (n == 1 && edges.length == 0) {
            return true;
        }
        // make sure edges should be n - 1
        if (edges == null || edges.length < n - 1 || edges.length >= n) {
            return false;
        }

        // build a graph with edges
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<Integer>());
            }
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<Integer>());
            }
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        // traverse graph to check if there is a cycle
        Set<Integer> visited = new HashSet<>();
        if (hasCycle(-1, 0, visited, map)) {
            return false;
        }
        if (visited.size() != n) {
            return false;
        }

        return true;
    }

    public boolean hasCycle(int prev, int curr, Set<Integer> visited, Map<Integer, ArrayList<Integer>> map) {
        visited.add(curr);
        for (int neighbor : map.get(curr)) {
            if (neighbor == prev) {
                continue;
            }
            if (visited.contains(neighbor)) {
                return true;
            }
            if (hasCycle(curr, neighbor, visited, map)) {
                return true;
            }
        }

        return false;
    }
}