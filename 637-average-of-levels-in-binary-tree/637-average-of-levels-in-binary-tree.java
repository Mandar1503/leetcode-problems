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

//MY SOLUTION USING BFS
// class Solution {
//     public List<Double> averageOfLevels(TreeNode root) {
//         List<List<Integer>> levels = new LinkedList<>();
//         Queue<TreeNode> q = new LinkedList<>();
//         List<Double> result = new LinkedList<>();
//         int level =0;
        
//         if(root==null)
//             return result;
        
//         q.add(root);
        
//         while(!q.isEmpty())
//         {
//             levels.add(new LinkedList<Integer>());
//             int qsize = q.size();
//             for(int i=0;i<qsize;i++)
//             {
//                 TreeNode node =q.remove();
                   
//                 levels.get(level).add(node.val);
                
//                 if(node.left!=null)
//                     q.add(node.left);
//                 if(node.right!=null)
//                     q.add(node.right);
//             }
//             double sum =0;
//             for(int i=0;i<levels.get(level).size();i++)
//             {
//                 sum += levels.get(level).get(i); 
//             }
//             double avg = (double)sum/levels.get(level).size();
//             result.add(avg);
//             level++;
//         }
//         return result;
//     }
// }

//MY OPTIMIZED SOLUTION USING BFS(100%)
// class Solution {
//     public List<Double> averageOfLevels(TreeNode root) {
//         List<List<Integer>> levels = new LinkedList<>();
//         Queue<TreeNode> q = new LinkedList<>();
//         List<Double> result = new LinkedList<>();
//         int level =0;
        
//         if(root==null)
//             return result;
        
//         q.add(root);
        
//         while(!q.isEmpty())
//         {
//             int qsize = q.size();
//             double sum =0;
//             for(int i=0;i<qsize;i++)
//             {
//                 TreeNode node =q.remove();   
//                 sum += node.val;
        
//                 if(node.left!=null)
//                     q.add(node.left);
//                 if(node.right!=null)
//                     q.add(node.right);
//             }
//             result.add((double)sum/qsize);
//             level++;
//         }
//         return result;
//     }
// }

//THEIR SOLUTION = USING DFS 
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<Integer> count = new LinkedList<>();
        LinkedList<Double> res = new LinkedList<>();
        
        average(root,res,0,count);
        
        for(int i=0;i<res.size();i++)
            res.set(i,res.get(i)/count.get(i));
        return res;
    }
    
    private void average(TreeNode root, LinkedList<Double> res, int i, LinkedList<Integer> count)
    {
        if(root==null)
            return;
        if(i<res.size())    //IF THE LEVEL IS CREATED THEN JUST ADD INTO IT
        {
            res.set(i,res.get(i)+root.val);
            count.set(i,count.get(i)+1);    
        }
        else            //IF THE LEVEL IS NOT CREATED YET, THEN SET THE VALUES AS 1 
        {
            res.add(1.0*root.val);
            count.add(1);
        }
        
        
        average(root.left,res,i+1,count);
        average(root.right,res,i+1,count);
    }
}