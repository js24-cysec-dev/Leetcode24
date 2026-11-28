class Solution {
    ArrayList<Integer> al=new ArrayList<>();
    void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            al.add(root.val);
            inorder(root.right);
        }
    }
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for(int i=1;i<al.size();i++){
            if(al.get(i)<=al.get(i-1))return false;
        }
        return true;
    }
}
