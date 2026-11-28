
public class Codec {
    void preorder(TreeNode root,StringBuilder sb){
        if(root!=null){
            sb.append(root.val+",");
            preorder(root.left,sb);
            preorder(root.right,sb);
        }
    }
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preorder(root,sb);
        return new String(sb);
    }
    public TreeNode deserialize(String data) {
        if(data.isEmpty())return null;
        Queue<String> q=new LinkedList<>(Arrays.asList(data.split(",")));
        return construct(q,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    TreeNode construct(Queue<String> q,int lb, int ub){
        if(!q.isEmpty()){
            int x=Integer.parseInt(q.peek());
            if(x>lb && x<ub){
                q.poll();
                TreeNode node=new TreeNode(x);
                node.left=construct(q,lb,x);
                node.right=construct(q,x,ub);
                return node;
            }
        }
        return null;
    }
}
