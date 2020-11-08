package com.company.PQ;

/**
 * Created by Lindaliu on 2020-11-07.
 */
import java.util.*;
public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //sort interval by start time
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        //min heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(intervals.length,
                new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });
        //add first meeting
        pq.add(intervals[0][1]);
        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            pq.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return pq.size();
    }
}
