/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph,
                            DirectedGraphNode s, DirectedGraphNode t) {
        if (s == null || t == null) {
            return false;
        }

        if (s == t) {
            return true;
        }

        Set<DirectedGraphNode> visited = new HashSet<>();
        // do dfs from start
        Stack<DirectedGraphNode> stack = new Stack<>();
        stack.add(s);
        visited.add(s);

        while (!stack.empty()) {
            DirectedGraphNode curr = stack.pop();
            if (curr == t) {
                return true;
            }

            List<DirectedGraphNode> neighbors = curr.neighbors;
            for (DirectedGraphNode neighbor : neighbors) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                stack.push(neighbor);
                visited.add(neighbor);
            }
        }

        return false;
    }
}
