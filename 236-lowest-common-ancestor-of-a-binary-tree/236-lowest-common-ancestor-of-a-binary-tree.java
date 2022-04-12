/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurse(root,p,q);
        return ans;
    }
    
    private boolean recurse(TreeNode node, TreeNode p, TreeNode q)
    {
        if(node==null)
            return false;
        
        int left = recurse(node.left,p,q)?1:0;//set left true or false on the basis of its left childrens
        int right = recurse(node.right,p,q)?1:0;//set right true or false on the basis of its right childrens
        int mid = (node==p || node==q)?1:0;//set mid is true for the node since it is p or q
        
        if(mid+left+right>=2)  //if node is p/q and one of the l/r childrens other or l & r childrens contain p and q each then node is LCA
            ans = node;
        
        return (mid+left+right>0);  //to pass true or false values to the parent nodes
    }
}