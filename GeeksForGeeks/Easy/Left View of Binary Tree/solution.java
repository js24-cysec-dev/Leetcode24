class Solution {
    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                Node x = q.poll();
                if (i == 0) res.add(x.data);
                if (x.left != null) q.add(x.left);
                if (x.right != null) q.add(x.right);
            }
        }
        return res;
    }
}
