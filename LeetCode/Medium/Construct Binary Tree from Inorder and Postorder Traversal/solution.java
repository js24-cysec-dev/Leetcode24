class Solution {
    HashMap<Integer,Integer> hm=new HashMap<>();
    TreeNode construct(int post[],int pl,int ph,int in[],int il,int ih){
        if(pl>ph)return null;
        int ri=hm.get(post[ph]);
        int x=ri-il;
        TreeNode node=new TreeNode(in[ri]);
        node.left=construct(post,pl,pl+x-1,in,il,ri-1);
        node.right=construct(post,pl+x,ph-1,in,ri+1,ih);
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder){
        int n=inorder.length;
        for(int i=0;i<n;i++)hm.put(inorder[i],i);
      return construct(postorder,0,n-1,inorder,0,n-1);
    }
}
