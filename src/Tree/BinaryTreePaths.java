package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        System.out.println("Binary Tree Path: " + binaryTreePaths(root));
    }
    static ArrayList<String> list=new ArrayList<>();
    public static List<String> binaryTreePaths(TreeNode root) {
        helper(root,"");
        return list;
    }
    private static void helper(TreeNode node,String curPath){
        if(node==null)return ;
        curPath+=node.val;
        if(node.left==null&&node.right==null){
            list.add(curPath);
            return;
        }
        curPath+="->";
        helper(node.left,curPath);
        helper(node.right,curPath);
    }
}

/*
TC - 0(n)
SC - 0(N)
 */
