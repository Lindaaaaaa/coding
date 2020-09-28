package com.company.topK;

import java.util.PriorityQueue;

/**
 * Created by Lindaliu on 2020-08-04.
 */
public class kthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null|| nums.length==0) {
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a1,a2) -> a1-a2);
        for (int num: nums) {
            pq.add(num);
            if (pq.size()>k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
