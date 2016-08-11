class Solution {
public:
    int ladderLength(string start, 
        string end, 
        unordered_set<string> &dict
    ) {
        if (dict.size() == 0) return 0;
        if (start == end) return 1;

        unordered_set<string> hash;
        queue<string> q;

        dict.insert(end);
        q.push(start);
        hash.insert(start);

        int length = 1;
        while (!q.empty()) {
            length++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                string word = q.front();
                q.pop();
                for (string next : getNextWords(word, dict)) {
                    if (hash.find(next) != hash.end()) continue;
                    if (next == end) return length;
                    hash.insert(next);
                    q.push(next);
                }
            }
        }

        return 0;
    }
private:
    vector<string> getNextWords(string word,
        const unordered_set<string> &dict
    ) {
        vector<string> words;
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.size(); i++) {
                if (c == word[i]) continue;
                string next = word;
                next[i] = c;
                if (dict.find(next) != dict.end()) {
                    words.push_back(next);
                }
            }
        }

        return words;
    }
};