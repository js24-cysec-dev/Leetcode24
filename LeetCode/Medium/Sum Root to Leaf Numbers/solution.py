class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def preorder(root, s):
            if root == None:
                return 0
            if not root.left and not root.right:
                return s * 10 + root.val
            return preorder(root.left, s * 10 + root.val) + preorder(root.right, s * 10 + root.val)
        return preorder(root, 0)
