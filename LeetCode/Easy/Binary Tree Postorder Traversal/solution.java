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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>res = new ArrayList<Integer>();
        if(root==null) return res;
        Stack<TreeNode> st = new Stack<>();
        TreeNode t=root;
        while(true){
            if(t!=null){
                st.push(t);st.push(t);
                t=t.left;
            }else if(st.isEmpty())return res;
            else{
                t=st.pop();
                if(st.isEmpty()||t!=st.peek()){
                    res.add(t.val);
                    t=null;
                }else{
                    t=t.right;
                }
            }
        }
        
    }
}