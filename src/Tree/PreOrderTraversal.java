package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// root->left->right
public class PreOrderTraversal {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        System.out.println("PreOrder Traversal Recursive: " + preOrderRec(root));
        System.out.println("PreOrder Traversal Iterative:" + preOrderIter(root));
}

    static List<Integer> preOrderRec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root,res);
        return res;
    }

    static void traversal(TreeNode root, List<Integer> res){
        if(root!=null){
            res.add(root.val);
            if(root.left!=null){
                traversal(root.left,res);
            }
            if(root.right!=null){
                traversal(root.right,res);
            }
        }
    }

    static List<Integer> preOrderIter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root!=null){
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                res.add(node.val);
                if(node.right!=null){ // First push right and then left to stack as stack works LIFO
                    stack.push(node.right);
                }
                if (node.left!=null){
                    stack.push(node.left);
                }
            }
        }
        return res;
    }
}
