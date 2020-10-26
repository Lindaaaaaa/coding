package com.company.bfsAndDfs.bfs;

import java.util.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Lindaliu on 2020-10-10.
 */
public class AllNodesDistanceKInBinaryTree {
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
    // use hashmap
    // 1. build a undirected graph using treenodes as vertices, and the parent-child relation as edges
    // 2.do BFS with source vertice (target) to find all vertices with distance K to it.
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<Integer>();
        if (K==0) {
            res.add(target.val);
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        buildMap(root,map, null);
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(target.val);
        visited.add(target.val);
        int distance =0;
        while (!q.isEmpty()){
            distance++;
            int size = q.size();
            for(int i=0; i<size; i++) {
                int node = q.poll();
                List<Integer> children = map.get(node);
                for (Integer c: children) {
                    if (!visited.contains(c)) {
                        q.add(c);
                        visited.add(c);
                    }
                }
            }
            if (distance == K){
                res.addAll(q);
            }
        }
        return res;
    }

    public void buildMap(TreeNode root, Map<Integer, List<Integer>> map, TreeNode parent) {
        if (root == null) {
            return;
        }
        map.put(root.val, new LinkedList());
        if (parent!=null) {map.get(root.val).add(parent.val);}
        if (root.left!=null) {
            map.get(root.val).add(root.left.val);
            buildMap(root.left, map, root);
        }
        if (root.right!=null){
            map.get(root.val).add(root.right.val);
            buildMap(root.right, map, root);
        }
    }
}
