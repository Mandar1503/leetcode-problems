/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        stack<TreeNode*> stk;
        vector<int> result;
        TreeNode* node=root;
        
        while(!stk.empty() || node)
        {
            while(node)
            {
                stk.push(node);
                node=node->left;
            }
            node=stk.top();
            stk.pop();
            result.push_back(node->val);
            node=node->right;
        }
        return result;
    }
};

//RECURSIVE APPROACH
// class Solution {
// public:
//     vector<int> inorderTraversal(TreeNode* root) {
//         vector<int> result;
//         inorder(root,result);
//         return result;
//     }
    
//     void inorder(TreeNode* node,vector<int>& res)
//     {
//         if(!node)
//             return;
//         inorder(node->left,res);
//         res.push_back(node->val);
//         inorder(node->right,res);
//     }
// };