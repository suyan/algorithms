/**
 * Definition of TreeNode:
 * class TreeNode {
 * public:
 *     int val;
 *     TreeNode *left, *right;
 *     TreeNode(int val) {
 *         this->val = val;
 *         this->left = this->right = NULL;
 *     }
 * }
 */
class Solution {
public:
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    TreeNode* maxTree(vector<int> nums) {
        if (nums.size() == 0) return nullptr;
        
        stack<TreeNode*> s;
        
        for (int i = 0; i <= nums.size(); i++) {
            TreeNode *right = new TreeNode(i == nums.size() ? INT_MAX : nums[i]);
            while (!s.empty() && right->val >= s.top()->val) {
                TreeNode *curr = s.top();
                s.pop();
                if (s.empty()) {
                    right->left = curr;
                } else {
                    if (right->val < s.top()->val) {
                        right->left = curr;
                    } else {
                        s.top()->right = curr;
                    }
                }
            }
            s.push(right);
        }
        
        TreeNode *temp = s.top();s.pop();
        TreeNode *root = temp->left;
        delete temp;
        
        return root;
    }
};
