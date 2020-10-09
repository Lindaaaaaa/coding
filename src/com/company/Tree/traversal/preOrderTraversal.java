package com.company.Tree.traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Lindaliu on 2020-07-05.
 *
 add root to stack
 add right node and left node in order
 keep step 2 until stack is empty

 */
public class preOrderTraversal {
    /**
     * Definition for a binary tree node.
     */

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal_recursion(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal_recursion(root.left));
        res.addAll(preorderTraversal_recursion(root.right));
        return res;
    }
    /*
     add root to stack
     add right node and left node in order
     keep step 2 until stack is empty
     */
    public List<Integer> preorderTraversal_iteration(TreeNode root) {
        Stack<TreeNode> stack  = new Stack<>();
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right!=null) {
                stack.push(node.right);
            }
            if (node.left!=null) {
                stack.push(node.left);
            }
        }
        return res;
    }

}
