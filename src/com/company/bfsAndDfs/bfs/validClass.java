package com.company.bfsAndDfs.bfs;

import java.util.*;

/**
 * Created by Lindaliu on 2020-06-29.
 */
public class validClass {
    //    /*DFS template
// * Return true if there is a path from cur to target.
// */
//    boolean DFS(Node cur, Node target, Set<Node> visited) {
//        return true if cur is target;
//        for (next : each neighbor of cur) {
//            if (next is not in visited) {
//                add next to visted;
//                return true if DFS(next, target, visited) == true;
//            }
//        }
//        return false;
//    }

    /*
 * Return true if there is a path from cur to target.
 */
//    boolean DFS(int root, int target) {
//        Set<Node> visited;
//        Stack<Node> stack;
//        add root to stack;
//        while (s is not empty) {
//            Node cur = the top element in stack;
//            remove the cur from the stack;
//            return true if cur is target;
//            for (Node next : the neighbors of cur) {
//                if (next is not in visited) {
//                    add next to visited;
//                    add next to stack;
//                }
//            }
//        }
//        return false;
//    }

    // https://leetcode.com/articles/graph-valid-tree/
    // For the graph to be a valid tree, it must have exactly n - 1 edges.
    // Any less, and it can't possibly be fully connected.
    // Any more, and it has to contain cycles. Additionally,
    // if the graph is fully connected and contains exactly n - 1 edges, it can't possibly contain a cycle, and therefore must be a tree!
    public static boolean validTree_dfs_stack(int n, int[][] edges) {
        if (n == 1) {
            return true;
        }
        // theory,
        if (edges.length != n - 1) {
            return false;
        }
        //https://leetcode.com/articles/graph-valid-tree/
        List<List<Integer>> adjacencyList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new LinkedList<Integer>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neignbour : adjacencyList.get(node)) {
                if (!seen.contains(neignbour)) {
                    seen.add(neignbour);
                    stack.push(neignbour);
                }
            }
        }

        return seen.size() == n;
    }

    /* use map to store parent of a given node */
    public static boolean validTree_dfs_stack_map(int n, int[][] edges) {
        if (n == 1) {
            return true;
        }
        // theory,
        if (edges.length != n - 1) {
            return false;
        }
        //https://leetcode.com/articles/graph-valid-tree/
        List<List<Integer>> adjacencyList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new LinkedList<Integer>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neignbour : adjacencyList.get(node)) {
                if (!seen.contains(neignbour)) {
                    seen.add(neignbour);
                    stack.push(neignbour);
                }
            }
        }

        return seen.size() == n;
    }


    public static boolean validTree_dfs_recursion(int n, int[][] edges) {
        Set<Integer> seen = new HashSet<>();

        if (n == 1) {
            return true;
        }
        if (edges.length != n - 1) {
            return false;
        }
        List<List<Integer>> adjacencyList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new LinkedList<Integer>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        return dfs(0, -1, seen, adjacencyList) && seen.size() == n;
    }

    private static boolean dfs(int node, int parent, Set<Integer> seen, List<List<Integer>> adjacencyList) {
        if (seen.contains(node)) {
            return false;
        }
        seen.add(node);
        for (int neignbour : adjacencyList.get(node)){
            if (parent!=neignbour) {
                boolean result = dfs(neignbour, node, seen, adjacencyList);
                if (!result) return false;
            }
        }
        return true;
    }





    public static boolean validTree_bfs(int n, int[][] edges) {
        if(n==1) {
            return true;
        }
        // theory,
        if (edges.length != n-1) {
            return false;
        }
        //https://leetcode.com/articles/graph-valid-tree/
        List<List<Integer>> adjacencyList  = new LinkedList<>();
        for (int i =0; i< n; i++) {
            adjacencyList.add(new LinkedList<Integer>());
        }
        for (int[] edge: edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.add(0);
        seen.add(0);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for (int neighbor: adjacencyList.get(node)){
                queue.add(neighbor);
                seen.add(neighbor);
            }

        }
        return seen.size() == n;
    }

}
