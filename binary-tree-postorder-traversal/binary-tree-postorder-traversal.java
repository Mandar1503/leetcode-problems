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

//RECURSIVE APPROACH
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
        
//         ArrayList<Integer> l = new ArrayList<>();
//         postorder(root, l);
//         return l;
//     }
    
//     private void postorder(TreeNode root, ArrayList<Integer> l)
//     {
//         if(root==null)
//             return;
//         postorder(root.left,l);
//         postorder(root.right,l);
//         l.add(root.val);
//     }
// }

//RECURSIVE APPROACH  = SAME AS PREORDER JUST ADDFIRST IN THE ANS AND PUSH LEFT AND THEN RIGHT INTO THE STACK.
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        LinkedList<Integer> l = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if(root==null)
            return l;
        
        stack.push(root);                   //PUSH ROOT INTO STACK
        
        while(!stack.empty())
        {
            TreeNode node = stack.pop();    //POP AND ADDFIRST IN ANS
            l.addFirst(node.val);
            
            if(node.left!=null)             //LEFT
            {
                stack.push(node.left);
            }
            if(node.right!=null)            //RIGHT
            {
                stack.push(node.right);
            }
        }
        return l;
    }
}