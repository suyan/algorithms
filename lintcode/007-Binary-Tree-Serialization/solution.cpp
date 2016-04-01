class Solution {
public:
    string serialize(TreeNode *root) {
        string result;
        writeBinaryTree(root, result);
        
        return result;
    }

    TreeNode *deserialize(string data) {
        stringstream ss(data);
        TreeNode *root;
        readBinaryTree(root, ss);

        return root;
    }
private:
    // {1,#,3,2,1,#,#,1,#}
    void writeBinaryTree(TreeNode *root, string &result) {
        if (root == nullptr) {
            result += "#,";
        } else {
            result += to_string(root->val) + ",";
            writeBinaryTree(root->left, result);
            writeBinaryTree(root->right, result);
        }
    }

    void readBinaryTree(TreeNode* &root, stringstream &ss) {
        string curr;
        if (!getline(ss, curr, ',')) {
            return;
        }
        if (curr != "#") {
            root = new TreeNode(stoi(curr));
            readBinaryTree(root->left, ss);
            readBinaryTree(root->right, ss);
        } else {
            root = nullptr;
        }
    }
};

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if (root == nullptr) return "";
        string s;
        stack<TreeNode*> nodes;
        nodes.push(root);
        while (!nodes.empty()) {
            TreeNode *curr = nodes.top();
            nodes.pop();
            if (curr == nullptr) {
                s.append("#,");
            } else {
                s.append(to_string(curr->val) + ",");
                nodes.push(curr->right);
                nodes.push(curr->left);
            }
        }
        
        // remove last `,`
        s.resize(s.size() - 1);
        cout << s << endl;
        return s;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        if (data.size() == 0) return nullptr;
        stringstream ss(data);
        string val;
        TreeNode *root;
        stack<TreeNode**> nodes;
        nodes.push(&root);
        while (!nodes.empty()) {
            TreeNode **curr = nodes.top();
            nodes.pop();
            
            if (!getline(ss, val, ',')) {
                break;
            }
            
            if (val == "#") {
                *curr = nullptr;
            } else {
                *curr = new TreeNode(stoi(val));
                nodes.push(&(*curr)->right);
                nodes.push(&(*curr)->left);
            }
        }
        
        return root;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.deserialize(codec.serialize(root));