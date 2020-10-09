package com.company.graph.TopologicalSort;

/**
 * Created by Lindaliu on 2020-10-08.
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int index =0;
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
                res[index] = i;
                index++;
            }
        }

        while (!queue.isEmpty()) {
            int prereq = queue.poll();
            List<Integer> courses = adjList.get(prereq);
            for (int c: courses) {
                degree[c] = degree[c] - 1;
                if (degree[c] == 0) {
                    queue.add(c);
                    res[index] = c;
                    index++;
                }
            }
        }

        for (int i=0; i< numCourses; i++) {
            if (degree[i] != 0) {
                return new int[0];
            }
        }
        return res;
    }
}
