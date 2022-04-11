/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//RECURSIVE SOLUTION
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> l = new ArrayList<>();
        inorder(root,l);
        return l;
    }
    
    private void inorder(TreeNode root,ArrayList<Integer> l)
    {
        if(root==null)
            return;
        
        inorder(root.left,l);
        l.add(root.val);
        inorder(root.right,l);
    }
}