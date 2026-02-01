package Tree;

public class MaxPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Max Path Sum: " + maxPathSum(root));
    }

    private static int maxPathSum(TreeNode root) {
        int[] res = { root.val };
        dfs(root, res);
        return res[0];
    }

    private static int dfs(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }

        // Recursively compute the maximum sum of the left and right subtree paths.
        int leftSum = Math.max(0, dfs(node.left, res));
        int rightSum = Math.max(0, dfs(node.right, res));

        // Update the maximum path sum encountered so far (with split).
        res[0] = Math.max(res[0], leftSum + rightSum + node.val);

        // Return the maximum sum of the path (without split).
        return Math.max(leftSum, rightSum) + node.val;
    }
}

/*
Complexity Analysis
Time Complexity: O(N), each node is processed once in DFS Traversal.
Space Complexity: O(H), auxiliary stack space, where H is height of Binary Tree.
 */