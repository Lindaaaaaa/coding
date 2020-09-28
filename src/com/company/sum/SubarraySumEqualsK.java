package com.company.sum;

import java.util.HashMap;

/**
 * Created by Lindaliu on 2020-08-05.
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count= 0;
        for (int i =0; i< nums.length; i++) {
            int sum = 0;
            for (int j = i; j< nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // hashmap
    // the key is sum of index {i,j} is  prefix[j]- prefix[i-1], just check if that is k
    public int subarraySum_hashmap(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) +1);
        }
        return count;
    }
}
