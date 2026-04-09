package Tree;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        System.out.println("Right View Of Binary Tree: " + rightSideView(root));
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root==null) return res;
        rightView(root,res,0);
        return res;
    }

    static void rightView(TreeNode root, List<Integer> res, int level){
        if(root == null) return;

        if(level==res.size()){
            res.add(root.val);
        }

        if(root.right!=null){
            rightView(root.right,res,level+1);
        }

        if(root.left!=null){
            rightView(root.left,res,level+1);
        }

    }
}
