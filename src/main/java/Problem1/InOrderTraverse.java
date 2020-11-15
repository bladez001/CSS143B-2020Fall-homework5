package Problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraverse {
    public static List<Integer> inorderTraversalIterative(TreeNode<Integer> root) {
        // homework
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;

        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add((Integer) node.val);
            node = node.right;

            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return result;
    }
}
