package Problem2;

import Problem1.TreeNode;

public class LCA {
    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        // homework
        // hint: pay attention to the assumptions of this problem.
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) {
            return null;
        }else if(left != null && right != null){
            return root;
        }else if (left != null) {
            return left;
        }else {
            return right;
        }
    }
}
