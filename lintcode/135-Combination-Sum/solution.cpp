class Solution {
public:
    vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
        vector<vector<int>> result;
        if (candidates.size() == 0) return result;
        
        vector<int> path;
        sort(candidates.begin(), candidates.end());
        
        helper(candidates, target, path, 0, result);
        
        return result;
    }
private:
    void helper(const vector<int> &candidates, int target, vector<int> &path, int index, vector<vector<int>> &result) {
        if (target == 0) {
            result.push_back(path);
            return;
        }
        
        for (int i = index; i < candidates.size(); i++) {
            if (candidates[i] > target) {
                break;
            }
            
            if (i != index && candidates[i] == candidates[i-1]) {
                continue;
            }
            
            path.push_back(candidates[i]);
            helper(candidates, target - candidates[i], path, i, result);
            path.pop_back();
        }
    }
};
