package ExtraCredit;

import Problem1.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Based on solution from geeksforgeeks
//https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
public class KDistance {
    public static List<Integer> distanceK(TreeNode<Integer> root, TreeNode<Integer> target, int k) {
        // homework
        List<Integer> result = new ArrayList<>();
        findDistanceK(root, target, k, result);
        return result;
    }

    private static int findDistanceK (TreeNode<Integer> root, TreeNode<Integer> target, int k, List<Integer> result) {
        if (root == null) {
            return -1;
        }
        // target is same as root so we add it to the result
        if (root == target) {
            findDistanceKDown(target, k, result);
            return 0;
        }
        //search through left tree
        int l = findDistanceK(root.left, target, k, result);

        if (l != -1) {
            if (l + 1 == k) {
                //root is at distance k from target in left child so again we add it to result
                result.add(root.val);
            }else{
                // here we go to the right subtree and print all k-l-2 distant nodes
                findDistanceKDown(root.right, k - l - 2, result);
            }
            return 1 + l;
        }
        //search through right tree just like above
        int r = findDistanceK(root.right, target, k, result);

        if (r != -1) {
            if (r + 1 == k) {
                result.add(root.val);
            }else{
                findDistanceKDown(root.left, k - r - 2, result);
            }
            return 1 + r;
        }
        //at this point target was not found
        return -1;
    }

    private static List<Integer> findDistanceKDown (TreeNode<Integer> node, int k, List<Integer> result) {
        if(node == null || k < 0){
            return result;
        }

        //subtract 1 from k at each recursion call and when we reach 0, we are at distance k
        if(k == 0){
            result.add(node.val);
            return result;
        }

        //recursive call to go down through left and right trees
        findDistanceKDown(node.left, k - 1, result);
        findDistanceKDown(node.right, k - 1, result);

        return result;
    }

}
