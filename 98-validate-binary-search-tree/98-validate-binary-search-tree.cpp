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

//Recursive traversal with valid range
// class Solution {
// public:
//     bool isValidBST(TreeNode* root) {
//      return validate(root,NULL,NULL);   
//     }
    
//     bool validate(TreeNode* root, TreeNode* low, TreeNode* high)
//     {
//         if(root==NULL)
//             return true;
        
//         if((low!=NULL && low->val >= root->val)||(high!=NULL && high->val <= root->val))
//             return false;
        
//         return validate(root->left,low,root) && validate(root->right,root,high);
//     }
// };


//Recursive inorder Traversal
class Solution {
public:
    TreeNode* prev;
    bool isValidBST(TreeNode* root) {
        prev = NULL;
        return inorder(root);
    }
    
    bool inorder(TreeNode* root)
    {
        if(root==NULL)
            return true;
        if(!inorder(root->left))
            return false;
        if(prev!=NULL && root->val <= prev->val)
            return false;
        prev = root;
        return inorder(root->right);
    }
};