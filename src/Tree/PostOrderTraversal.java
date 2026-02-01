package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        System.out.println("PostOrder Traversal Rec: " + postOrderRec(root));
        System.out.println("PostOrder Traversal Itr: " + postOrderItr(root));
    }

    static List<Integer> postOrderRec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root,res);
        return res;
    }

    static void traversal(TreeNode root, List<Integer> res){
        if(root!=null){
            if(root.left!=null){
                traversal(root.left,res);
            }
            if(root.right!=null){
                traversal(root.right,res);
            }
            res.add(root.val);
        }
    }

    static  List<Integer> postOrderItr(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if(root==null) return  res;
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left!=null){
                stack1.push(node.left);
            }
            if (node.right!=null){
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()){
            TreeNode node1 = stack2.pop();
            res.add(node1.val);
        }
        return res;
    }
}
