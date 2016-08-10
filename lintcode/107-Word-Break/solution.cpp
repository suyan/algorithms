class Solution {
public:
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    bool wordBreak(string s, unordered_set<string> &dict) {
        // dp(i): the position we cut can be word
        // dp(i) = true when dp(j) = true && dict[s[i - j]] = true
        vector<bool> dp(s.size() + 1, false);
        dp[0] = true; // empty string
        
        int max_length = 0;
        for (auto it : dict) {
            if (it.size() > max_length) {
                max_length = it.size();
            }
        }

        // fill dp
        for (int i = 1; i < dp.size(); i++) {
            // from right to left, we don't need to search more than longest word
            for (int j = i - 1; j >= 0 && j >= i - max_length; j--) {
                if (dict.find(s.substr(j, i - j)) != dict.end() && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[dp.size() - 1];
    }
};
