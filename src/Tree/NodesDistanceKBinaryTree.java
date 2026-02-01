package Tree;

import java.util.*;

// TreeNode class
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class NodesDistanceKBinaryTree {
     // This method marks the parent of each node in the binary tree.
     // It uses a BFS approach to traverse the tree and store parent-child relationships.
    private void markParent(TreeNode root, Map<TreeNode, TreeNode> parent_track, TreeNode target){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left!=null){
                parent_track.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right!=null){
                parent_track.put(node.right,node);
                q.offer(node.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParent(root,parent_track,target);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int curr_level=0;
        while(!q.isEmpty()){
            int size = q.size();
            if(curr_level==k) break;
            curr_level++;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left!=null && visited.get(node.left)==null){
                    q.offer(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    q.offer(node.right);
                    visited.put(node.right,true);
                }
                if(parent_track.get(node)!=null && visited.get(parent_track.get(node))==null){
                    q.offer(parent_track.get(node));
                    visited.put(parent_track.get(node),true);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            res.add(curr.val);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        NodesDistanceKBinaryTree sol = new NodesDistanceKBinaryTree();
        TreeNode target = root.left;
        int k = 2;
        // Find nodes at distance 2 from the target node
        List<Integer> result = sol.distanceK(root, target, k);

        // Print the elements at distance k from the target node
        System.out.print("Nodes at distance " + k + " from target node " + target.val + ": ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    }
