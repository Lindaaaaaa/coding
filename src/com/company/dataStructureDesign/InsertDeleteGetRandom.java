package com.company.dataStructureDesign;
import java.util.*;
/**
 * Created by Lindaliu on 2020-11-03.
 */

// insert delete Get Random, all O(1), insert and delete get easily get O(1) in hash map, put random you need index, which
// comes from array. However, delete value from array takes O(n), to make it O(1), swap position of value with last element
    // in array, then pop last element
public class InsertDeleteGetRandom {
    class RandomizedSet {
        Map<Integer, Integer> map;
        List<Integer> list;
        Random rand;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            rand = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int lastElement = list.get(list.size()-1);
            int index = map.get(val);
            int temp = list.get(index);
            list.set(index, lastElement);
            list.remove(list.size()-1);
            map.put(lastElement, index);
            map.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int index = rand.nextInt(list.size());
            return list.get(index);
        }
    }
}
