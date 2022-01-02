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

//Iterative solution using stack
// class Solution {
// public:
//     vector<int> preorderTraversal(TreeNode* root) {
//         vector<int> result;
//         stack<TreeNode*> stk;
        
//         if(!root)         //check if the root is null, if yes return otherwise further it will give you a error stating pointer accessed having null value
//             return result;
        
//         stk.push(root);//push first root
//         while(!stk.empty()) //until stack empty
//         {
//             TreeNode* node = stk.top(); //get top node
//             result.push_back(node->val);//push the value
//             stk.pop();                  //pop the first element
//             if(node->right)             //first right
//                 stk.push(node->right);
//             if(node->left)              //then left
//                 stk.push(node->left);
//         }
//         return result;
//     }
// };


//USING RECURSION 
class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result;
        preorder(root,result);
        return result;
    }
    
    void preorder(TreeNode* root, vector<int>& res)
    {
        if(root == NULL)
            return;
        res.push_back(root->val);
        preorder(root->left,res);
        preorder(root->right,res);
    }
};


//USING MORRIS TRAVERSAL - Very complicated
// class Solution {
// public:
//     vector<int> preorderTraversal(TreeNode* root) {
//         TreeNode* node = root;
//         vector<int> result;
//         while(node)
//         {
//             if(node->left)
//             {
//                 TreeNode* predecessor = node->left;
//                 while(predecessor->right && predecessor->right != node)
//                 {
//                     predecessor=predecessor->right;
//                 }
//                 if(!predecessor->right)
//                 {
//                     result.push_back(node->val);
//                     predecessor->right = node;
//                     node = node->left;
//                 }
//                 else
//                 {
//                     predecessor->right= NULL;
//                     node=node->right;
//                 }
//             }
//             else
//             {
//                 result.push_back(node->val);
//                 node=node->right;
//             }
//         }
//         return result;
//     }
// };