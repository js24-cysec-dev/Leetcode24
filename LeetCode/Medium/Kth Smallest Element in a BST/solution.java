class Solution {
    int c=0,res=0;
    void inorder(TreeNode root,int k){
        if(root!=null){
            inorder(root.left,k);
            c++;
            if(c==k){res=root.val;return;}
            inorder(root.right,k);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return res;
    }
}
