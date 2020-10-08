package com.Tree.recursion;

/**
 * Created by Lindaliu on 2020-10-03.
 * https://leetcode.com/problems/maximum-average-subtree/submissions/
 * skip
 */
public class maximumAverageSubtree {


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

    double max = Integer.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return max;

    }

    public double[] helper(TreeNode root) {
        if (root == null) {
            return new double[]{0.0,0.0};
        }
        double[] left = helper(root.left);
        double[] right = helper(root.right);
        double[] subTree = new double[]{left[0]+right[0]+root.val, left[1]+right[1]+1};
        double avgsubTree = (double)(subTree[0]/subTree[1]);
        if (avgsubTree > max) {
            max = avgsubTree;
        }
        return subTree;
    }
}
