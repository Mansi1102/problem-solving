package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> q = new LinkedList<>();
        q.offerFirst(root);
        boolean reverse = false;

        while (!q.isEmpty()) {
            List<Integer> current = new ArrayList<>();
            int level = q.size();

            for (int i = 0; i < level; i++) {
                if (!reverse) {
                    TreeNode curr = q.pollFirst();
                    current.add(curr.val);
                    if (curr.left != null) q.offerLast(curr.left);
                    if (curr.right != null) q.offerLast(curr.right);
                } else {
                    TreeNode curr = q.pollLast();
                    current.add(curr.val);
                    if (curr.right != null) q.offerFirst(curr.right);
                    if (curr.left != null) q.offerFirst(curr.left);
                }
            }

            res.add(current);
            reverse = !reverse;
        }

        return res;
    }
}
