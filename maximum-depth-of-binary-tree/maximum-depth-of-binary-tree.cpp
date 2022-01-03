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

//RECURSIVE APPROACH
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if(!root)
            return 0;
        
        return max(maxDepth(root->left),maxDepth(root->right))+1;
    }
};


//This ITERATIVE APPROACH is done by implementing bfs only not storing the nodes, just incrementing the depth counter after each loop i.e. each level

// class Solution {
// public:
//     int maxDepth(TreeNode* root) {
       
//         if(!root)
//             return 0;
//         queue<TreeNode*> q;
        
//         q.push(root);
//         int depth =0;
        
//         while(!q.empty())
//         {
//             depth++;
//             int count = q.size();
//             for(int i=0;i<count;i++)
//             {
//                 TreeNode* node = q.front();
//                 q.pop();

//                 if(node->left)
//                     q.push(node->left);
            
//                 if(node->right)
//                     q.push(node->right);
//             }
//         }
//         return depth;   
//     }    
// };