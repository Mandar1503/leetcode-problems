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
    vector<vector<int>> levelOrder(TreeNode* root) {
        queue<TreeNode*> q;
        vector<int> res;
        vector<vector<int>> result;
        
        if(!root)                       //for empty tree
            return result;  
        
        q.push(root);                   //push the root into q
        
        while(!q.empty())               //until q empty
        {
            int count = q.size();       //count the elements in the q currently for a level  
            
            for(int i=0;i<count;i++)    //iterate through the count 
            {
                root = q.front();       //pop and push its value into res
                q.pop();
                res.push_back(root->val);
                
                if(root->left)          //add left ele in q
                {
                    q.push(root->left);
                }
                if(root->right)
                {
                    q.push(root->right); //add right ele in q
                }
            }
            result.push_back(res);      
            res.clear();
        }
        return result;
    }
};