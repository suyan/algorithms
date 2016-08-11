class Solution {
public:
    vector<vector<string>> findLadders(string start,
                                       string end,
                                       unordered_set<string> &dict
                                       ) {
        vector<vector<string>> ladders;
        // graph node
        unordered_map<string, vector<string>> map;
        // distance from start to current node
        unordered_map<string, int> distance;
        
        dict.insert(start);
        dict.insert(end);
        
        bfs(map, distance, start, end, dict);
        vector<string> path;
        dfs(ladders, path, end, start, distance, map);
        
        return ladders;
    }
private:
    void dfs(vector<vector<string>> &ladders,
             vector<string> &path,
             string current,
             string start,
             unordered_map<string, int> &distance,
             unordered_map<string, vector<string>> &map
             ) {
        path.push_back(current);
        if (current == start) {
            reverse(path.begin(), path.end());
            ladders.push_back(path);
            reverse(path.begin(), path.end());
        } else {
            for (string next : map[current]) {
                if (distance.find(next) != distance.end()
                    && (distance[current] == distance[next] + 1)
                    ) {
                    dfs(ladders, path, next, start, distance, map);
                }
            }
        }
        path.pop_back();
    }
    void bfs(unordered_map<string, vector<string>> &map,
             unordered_map<string, int> &distance,
             string start,
             string end,
             const unordered_set<string> &dict
             ) {
        queue<string> q;
        q.push(start);
        distance[start] = 0;
        for (string s : dict) {
            map[s] = vector<string>(0, "");
        }
        
        while (!q.empty()) {
            string current = q.front();
            q.pop();
            for (string next : getNextWords(current, dict)) {
                map[next].push_back(current);
                if (distance.find(next) == distance.end()) {
                    distance[next] = distance[current] + 1;
                    q.push(next);
                }
            }
        }
    }
    
    vector<string> getNextWords(string word,
                                const unordered_set<string> &dict
                                ) {
        vector<string> words;
        for (int i = 0; i < word.size(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word[i]) continue;
                string temp(word);
                temp[i] = c;
                if (dict.find(temp) != dict.end()) {
                    words.push_back(temp);
                }
            }
        }
        
        return words;
    }
};