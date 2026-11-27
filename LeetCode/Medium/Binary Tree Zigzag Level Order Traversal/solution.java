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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List <List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) return res;
        ArrayDeque <TreeNode> q = new ArrayDeque<>();
        q.add(root);int level=1;
        while(!q.isEmpty()){
            int s = q.size();
            List  <Integer> t = new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode x = q.poll();
                t.add(x.val);
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }
            if(level%2==0)Collections.reverse(t);
            res.add(t);
            level ++;
        }
        return res;
    }
}