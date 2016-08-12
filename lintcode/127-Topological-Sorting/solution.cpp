/**
 * Definition for Directed graph.
 * struct DirectedGraphNode {
 *     int label;
 *     vector<DirectedGraphNode *> neighbors;
 *     DirectedGraphNode(int x) : label(x) {};
 * };
 */
class Solution {
public:
    vector<DirectedGraphNode*> topSort(vector<DirectedGraphNode*> graph) {
        vector<DirectedGraphNode*> result;
        if (graph.size() == 0) return result;
        
        unordered_map<DirectedGraphNode*, int> m;
        queue<DirectedGraphNode*> q;
        
        for (DirectedGraphNode *node : graph) {
            for (DirectedGraphNode *neighbor : node->neighbors) {
                if (m.find(neighbor) == m.end()) {
                    m[neighbor] = 1;
                } else {
                    m[neighbor]++;
                }
            }
        }
        
        for (DirectedGraphNode *node : graph) {
            if (m.find(node) == m.end()) {
                q.push(node);
            }
        }
        
        while (!q.empty()) {
            DirectedGraphNode *curr = q.front();
            q.pop();
            result.push_back(curr);
            for (DirectedGraphNode *neighbor : curr->neighbors) {
                m[neighbor]--;
                if (m[neighbor] == 0) {
                    q.push(neighbor);
                }
            }
        }
        
        return result;
    }
};
