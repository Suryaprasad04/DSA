// leetcode-1315

class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, null, null);
    }

    private int dfs(TreeNode current, TreeNode parent, TreeNode grandparent) {
        if (current == null) return 0;

        int sum = 0;

        // Check if grandparent exists and is even-valued
        if (grandparent != null && grandparent.val % 2 == 0) {
            sum += current.val;
        }

        // Recur for left and right child
        sum += dfs(current.left, current, parent);
        sum += dfs(current.right, current, parent);

        return sum;
    }
}
