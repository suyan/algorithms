class Solution {
public:
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    int longestConsecutive(vector<int> &num) {
        if (num.size() == 0) return 0;
        
        unordered_set<int> m;
        for (int i : num) {
            m.insert(i);
        }
        
        // go through the set
        int result = 0;
        while (!m.empty()) {
            int i = *(m.begin());
            int sum = 1;
            m.erase(i);

            int index = i - 1;
            while (m.find(index) != m.end()) {
                sum++;
                m.erase(index);
                index--;
            }
            
            index = i + 1;
            while (m.find(index) != m.end()) {
                sum++;
                m.erase(index);
                index++;
            }
            
            result = max(result, sum);
        }
        
        return result;
    }
};
