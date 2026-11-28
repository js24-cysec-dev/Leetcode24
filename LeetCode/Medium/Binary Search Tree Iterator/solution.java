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
class BSTIterator {
    List<Integer> list;
    int index = -1;

    public void Inorder(TreeNode root) {
        if(root == null) return;

        Inorder(root.left);
        list.add(root.val);
        Inorder(root.right);
    }

    public BSTIterator(TreeNode root) {
        list = new ArrayList<Integer>();
        Inorder(root);
    }
    
    public int next() {
        index++;
        return list.get(index);
    }
    
    public boolean hasNext() {
        return index < list.size()-1;
    }
}