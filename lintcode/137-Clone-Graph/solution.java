/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        // traverse graph and use a hashmap to store old and new node
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Stack<UndirectedGraphNode> stack = new Stack<>();
        map.put(node, new UndirectedGraphNode(node.label));
        stack.push(node);

        while (!stack.empty()) {
            UndirectedGraphNode curr = stack.pop();
            for (UndirectedGraphNode neighbor : curr.neighbors) {
                if (map.containsKey(neighbor)) {
                    continue;
                }
                map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                stack.push(neighbor);
            }
        }

        // copy neighbors
        for (Map.Entry<UndirectedGraphNode, UndirectedGraphNode> entry : map.entrySet()) {
            UndirectedGraphNode oldNode = entry.getKey();
            UndirectedGraphNode newNode = entry.getValue();
            for (UndirectedGraphNode neighbor : oldNode.neighbors) {
                newNode.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}