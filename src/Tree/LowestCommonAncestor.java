package Tree;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left;
        TreeNode q = root.right;


        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lca.val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base case:
        // If the current node is null, or if it matches p or q,
        // return the current node as a potential ancestor
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively search for p and q in the left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // Recursively search for p and q in the right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If p and q are both found in the right subtree,
        // then the LCA lies in the right subtree
        if (left == null) {
            return right;
        }
        // If p and q are both found in the left subtree,
        // then the LCA lies in the left subtree
        else if (right == null) {
            return left;
        }
        // If one node is found in the left subtree and the other in the right subtree,
        // then the current node is the Lowest Common Ancestor
        else {
            return root;
        }
    }
}

/*
Time Complexity  - O(n)
Space Complexity - O(h) → O(log n) average, O(n) worst
 */
