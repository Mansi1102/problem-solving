package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        System.out.println("Inorder Traversal Rec: " + inOrderRec(root));
        System.out.println("Inorder Traversal Iter: " + inOrderItr(root));
    }

    static List<Integer> inOrderRec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    static void traversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                traversal(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                traversal(root.right, res);
            }
        }
    }

    static List<Integer> inOrderItr(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }
}
