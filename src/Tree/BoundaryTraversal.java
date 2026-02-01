package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);

        System.out.println("Boundary Order Traversal:" + boundaryTraversal(root));
    }



    public static List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        // Step 1: Add root (only if not leaf)
        if (!isLeaf(root)) {
            res.add(root.val);
        }

        // Step 2: Left Boundary
        addLeftBoundary(root.left,res);

        // Step 3: Leaf Nodes
        addLeaves(root,res);

        // Step 4: Right Boundary
        addRightBoundary(root.right,res);

        return res;
    }

    private static void addLeftBoundary(TreeNode node,List<Integer> res) {
        while (node != null) {
            if (!isLeaf(node)) {
                res.add(node.val);
            }
            node = (node.left != null) ? node.left : node.right;
        }
    }

    private static void addRightBoundary(TreeNode node,List<Integer> res) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) {
                stack.push(node.val);
            }
            node = (node.right != null) ? node.right : node.left;
        }

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }

    private  static void addLeaves(TreeNode node,List<Integer> res) {
        if (node == null) return;

        if (isLeaf(node)) {
            res.add(node.val);
            return;
        }

        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
