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

//RECURSIVE SOLUTION
// class Solution {
// public:
//     TreeNode* searchBST(TreeNode* root, int val) {
      
//         if(root==NULL || root->val==val)
//             return root;
        
//         return root->val>val?searchBST(root->left,val):searchBST(root->right,val);
//         // if(root->val>val)
//         //    return searchBST(root->left,val);
//         // else
//         //    return searchBST(root->right,val);
//     }
// };

//ITERATIVE SOLUTION
// class Solution {
// public:
//     TreeNode* searchBST(TreeNode* root, int val) {
//         while(root!=NULL)
//         {
//             if(root->val<val)
//                 root=root->right;
//             else if(root->val>val)
//                 root=root->left;
//             else if(root->val==val)
//                 return root;
//         }
//     return NULL;
//     }
// };

//ITERATIVE SOLUTION(Just better code)
class Solution {
public:
    TreeNode* searchBST(TreeNode* root, int val) {
        while(root!=NULL && root->val!=val)
        {
            root = root->val<val?root->right:root->left;
        }
    return root;
    }
};

