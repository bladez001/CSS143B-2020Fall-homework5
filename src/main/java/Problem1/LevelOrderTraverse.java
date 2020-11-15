package Problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;


public class LevelOrderTraverse {
    public static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        // homework
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        /*I chose to use Linked List for this problem. I chose
          linked list because it works well with queue. The reason
          it works well is because queue needs a structure that has
          quick insertion and removal. Another reason is that it
          does not have a fixed size.
        */

        if (root == null) {
            return result;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                list.add((Integer) temp.val);

                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
