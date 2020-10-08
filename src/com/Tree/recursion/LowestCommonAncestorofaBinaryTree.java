package com.Tree.recursion;

import java.util.*;

/**
 * Created by Lindaliu on 2020-10-06.
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorofaBinaryTree {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    // travsersal on the tree until find p and q, use a map to track each node's parent.
    // lowest common ancestor will be the
    public TreeNode lowestCommonAncestor_interative(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map= new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map.put(root, null);
        while(!map.containsKey(p) || !map.containsKey(q)){
            TreeNode node = queue.poll();
            if (node.left!=null) {
                map.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right!=null) {
                map.put(node.right, node);
                queue.add(node.right);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }
        while (!set.contains(q)) {
            q = map.get(q);
        }
        return q;
    }
}
