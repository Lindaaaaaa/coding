package com.company.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lindaliu on 2020-10-04.
 */
public class MinimumDepthofBinaryTree {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public int minDepth_recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left ==0 || right ==0)? left+right+1: Math.min(left, right)+1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            depth ++;
            System.out.println(q.size());
            int size = q.size();
            for (int i =0; i< size; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left!=null) {
                    q.add(node.left);
                }
                if (node.right!=null) {
                    q.add(node.right);
                }
            }
        }
        return depth;
    }


}
