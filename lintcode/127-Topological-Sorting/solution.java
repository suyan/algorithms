/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        List<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        if (graph == null || graph.size() == 0) {
            return result;
        }

        // build hash map for node and incoming degree
        HashMap<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            if (!map.contains(node)) {
                map.put(node, 0);
            }
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (!map.contains(neighbor)) {
                    map.put(neighbor, 1);
                } else {
                    map.put(neighbor, map.get(neighbor) + 1);
                }
            }
        }

        // find root which has 0 incoming degree 
        DirectedGraphNode root = null;
        for (Map.Entry<DirectedGraphNode, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                root = entry.getKey();
                break;
            }
        }
        map.remove(root);

        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            DirectedGraphNode curr = queue.remove();
            result.add(curr);
            for (DirectedGraphNode neighbor : curr.neighbors) {
                if (map.get(neighbor) == 1) {
                    map.remove(neighbor);
                    queue.add(neighbor);
                } else {
                    map.put(neighbor, map.get(neighbor) - 1);
                }
            }
        }

        return result;
    }
}