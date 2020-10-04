package com.AmazoOA;

import java.util.PriorityQueue;

/**
 * Created by Lindaliu on 2020-09-28.
 */
public class FindMedianfromDataStream {
    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a1, a2) -> a1-a2);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a1,a2) -> a2-a1);
    boolean even = true;
    public FindMedianfromDataStream() {

    }

    public void addNum(int num) {
        if (even) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        even = !even;
    }


    public double findMedian() {
        if (even) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        else {
            return maxHeap.peek();
        }
    }
}
