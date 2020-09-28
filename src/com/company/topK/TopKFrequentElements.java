package com.company.topK;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Lindaliu on 2020-06-28.
 */
public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums ==null ||nums.length ==0) {
            return null;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) +1 );
        }
        //{1,4}, {2,2},{3,1}
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> count.get(a) - count.get(b)
        );
        for (Integer num : count.keySet()) {
            pq.add(num);
            int peek = pq.peek();
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int j = k - 1; j >= 0; j--) {
            res[j] = pq.poll();
        }
        return res;
    }
}
