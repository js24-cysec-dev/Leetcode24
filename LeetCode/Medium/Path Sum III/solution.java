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
    int count = 0;
    int k;
    Map<Long, Integer> prefixSumCount = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        this.k = targetSum;
    
        prefixSumCount.put(0L, 1);
        dfs(root, 0L);
        return count;
    }

    private void dfs(TreeNode node, long currentSum) {
        if (node == null) {
            return;
        }

        currentSum += node.val;

        count += prefixSumCount.getOrDefault(currentSum - k, 0);

        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        dfs(node.left, currentSum);
        dfs(node.right, currentSum);

       
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
    }
}