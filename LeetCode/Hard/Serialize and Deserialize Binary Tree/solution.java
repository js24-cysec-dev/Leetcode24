public class Codec {
    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        preorder(root, sb);
        return sb.toString();
    }

    private TreeNode preorderBuild(Queue<String> pre) {
        String val = pre.poll();
        if (val.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = preorderBuild(pre);
        node.right = preorderBuild(pre);
        return node;
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        Queue<String> str = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return preorderBuild(str);
    }
}