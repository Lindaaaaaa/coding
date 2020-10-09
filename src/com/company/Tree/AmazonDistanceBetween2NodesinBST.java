package com.company.Tree;

/**
 * Created by Lindaliu on 2020-10-06.
 * Write a function that given a BST, it will return the distance (number of edges) between 2 nodes.
 * https://leetcode.com/discuss/interview-question/algorithms/125084/given-a-binary-search-tree-find-the-distance-between-2-nodes

 For example, given this tree

 5
 / \
 3   6
 / \   \
 2   4   7
 /         \
 1           8
 The distance between 1 and 4 is 3: [1 -> 2 -> 3 -> 4]

 The distance between 1 and 8 is 6: [1 -> 2 -> 3 -> 5 -> 6 -> 7 -> 8]
 Time complexity O(h) where h is the height of the tree
 */
public class AmazonDistanceBetween2NodesinBST {
    // this is my solution, validated solution is https://leetcode.com/discuss/interview-question/algorithms/125084/given-a-binary-search-tree-find-the-distance-between-2-nodes
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int bstDistance(TreeNode root, int node1, int node2) {
        if (root == null) {
            return -1;
        }
        TreeNode lcaNode = lca(root, node1, node2);
        return calDistance(lcaNode, node1) + calDistance(lcaNode, node2);
    }

    public int calDistance(TreeNode root, int node){
        if (root == null || root.val == node) {
            return 0;
        }
        if (root.val > node) {
            return 1+ calDistance(root.left, node);
        }
        return 1+ calDistance(root.right,node);
    }

    public TreeNode lca(TreeNode root, int node1, int node2) {
        if (root == null) {
            return null;
        }
        if (root.val == node1 || root.val == node2) {
            return root;
        }
        if (root.val> node1 && root.val > node2) {
            return lca(root.left, node1, node2);
        }
        if (root.val< node1 && root.val < node2) {
            return lca(root.right, node1, node2);
        }
        return root;
    }
}
