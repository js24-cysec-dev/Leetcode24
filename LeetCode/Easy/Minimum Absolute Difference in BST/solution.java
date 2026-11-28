class Solution {
    void inorder(TreeNode root, ArrayList<Integer> a) {
        if (root != null) {
            inorder(root.left, a);
            a.add(root.val);
            inorder(root.right, a);
        }
    }

    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> a = new ArrayList<>();
        inorder(root, a);
        int mn = Integer.MAX_VALUE;
        for (int i = 1; i < a.size(); i++) {
            mn = Math.min(mn, Math.abs(a.get(i) - a.get(i - 1)));
        }
        return mn;
    }
}
