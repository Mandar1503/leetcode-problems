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
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
        
//         LinkedList<Integer> l = new LinkedList<>();
//         preorder(root,l);
//         return l;
//     }
//     private void preorder(TreeNode root, LinkedList<Integer> l)
//     {
//         if(root==null)
//             return; 
//         l.add(root.val);
//         preorder(root.left,l);
//         preorder(root.right,l);
//     }
// }


//ITERATIVE APPROACH
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();// LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        
        if(root==null)
            return output;
        
        stack.add(root);
        
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();//TreeNode node = stack.pollLast();
            output.add(node.val);
            
            if(node.right!=null)
            {
                stack.push(node.right);//stack.add(node.right);
            }
            if(node.left!=null)
            {
                stack.push(node.left);//stack.add(node.left);
            }
        }
        
        return output;
    }
}

