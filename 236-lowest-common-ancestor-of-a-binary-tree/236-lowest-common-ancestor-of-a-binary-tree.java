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
        
        int left = recurse(node.left,p,q)?1:0;
        int right = recurse(node.right,p,q)?1:0;
        int mid = (node==p || node==q)?1:0;
        
        if(mid+left+right>=2)
            ans = node;
        
        return (mid+left+right>0);
    }
}