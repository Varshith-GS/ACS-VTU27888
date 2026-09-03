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
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<int[]> nodes = new ArrayList<>();

        // DFS: store {column, row, value}
        dfs(root, 0, 0, nodes);

        // Sort by:
        // 1. Column ascending
        // 2. Row ascending
        // 3. Value ascending
        Collections.sort(nodes, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[2], b[2]);
        });

        List<List<Integer>> result = new ArrayList<>();

        int previousColumn = Integer.MIN_VALUE;

        for (int[] node : nodes) {

            int column = node[0];
            int value = node[2];

            if (column != previousColumn) {
                result.add(new ArrayList<>());
                previousColumn = column;
            }

            result.get(result.size() - 1).add(value);
        }

        return result;
    }

    private void dfs(TreeNode root, int row, int column,
                     List<int[]> nodes) {

        if (root == null) {
            return;
        }

        nodes.add(new int[]{column, row, root.val});

        dfs(root.left, row + 1, column - 1, nodes);
        dfs(root.right, row + 1, column + 1, nodes);
    }
}
