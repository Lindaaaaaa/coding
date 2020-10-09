package com.company.graph.TopologicalSort;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Lindaliu on 2020-10-08.
 *
 */
public class CourseSchdule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList= new LinkedList<>();
        int[] degree = new int[numCourses];
        for (int i =0; i< numCourses; i++) {
            adjList.add(new LinkedList<Integer>());
        }
        for (int[] prereq: prerequisites){
            adjList.get(prereq[1]).add(prereq[0]);
            degree[prereq[0]]++;
        }
        // get all incoming degree 0 (no prereq courses)
        Queue<Integer> queue = new LinkedList();
        for (int i=0; i< numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int prereq = queue.poll();
            List<Integer> courses = adjList.get(prereq);
            for (int c: courses) {
                degree[c] = degree[c] - 1;
                if (degree[c] == 0) {
                    queue.add(c);
                }
            }
        }

        for (int i=0; i< numCourses; i++) {
            if (degree[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
