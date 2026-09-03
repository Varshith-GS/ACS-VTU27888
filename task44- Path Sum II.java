import java.util.*;

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, result);

        return result;
    }

    private void dfs(TreeNode root, int targetSum,
                     List<Integer> path,
                     List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        // Add current node to path
        path.add(root.val);

        // Check if current node is a leaf
        if (root.left == null && root.right == null) {

            if (root.val == targetSum) {
                result.add(new ArrayList<>(path));
            }

        } else {

            // Search left subtree
            dfs(root.left, targetSum - root.val, path, result);

            // Search right subtree
            dfs(root.right, targetSum - root.val, path, result);
        }

        // Backtrack
        path.remove(path.size() - 1);
    }
}
