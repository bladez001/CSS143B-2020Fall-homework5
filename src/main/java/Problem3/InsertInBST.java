package Problem3;

import Problem1.TreeNode;

public class InsertInBST {
    public static void insert(TreeNode<Integer> root, int valToInsert) {
        // homework
        if (root == null) {
            return;
        }
        if (root.val >= valToInsert ) {
            if (root.left == null) {
                root.left = new TreeNode<>(valToInsert);
            }else {
                insert(root.left, valToInsert);
            }
        }
        if (root.val < valToInsert) {
            if (root.right == null) {
                root.right = new TreeNode<>(valToInsert);
            }else {
                insert(root.right, valToInsert);
            }
        }
    }
}
