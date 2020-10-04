package com.AmazoOA;

import java.util.*;

/**
 * Created by Lindaliu on 2020-10-02.
 * https://leetcode.com/discuss/interview-question/855839/
 *
 */

/*
A virtual memory management system in an operating system at Amazon can use LeastRecently-Used (LRU) cache. When a requested memory page is not in the cache and the cache is full, the page that was least-recently-used should be removed from the cache to make room for the requested page. If the cache is not full, the requested page can simply be added to the cache and considered the most-recently-used page in the cache. A given page should occur at most once in the cache.
Given the maximum size of the cache and a list of page requests, write an algorithm to calculate the number of cache misses. A cache miss occurs when a page is requested and isn't found in the cache.

Input
The input to the function/method consists of three arguments:
num, an integer representing the number of pages;
pages, a list of integers representing the pages requested;
maxCacheSize, an integer representing the size of the cache.

Output
Return an integer representing the number of cache misses.

Note
The cache is initially empty and the list contains pages numbered in the range 1-50. A page at index "i" in the list is requested before a page at index "i+1".

Constraints

0 <= i < num

Example
Input:
num = 6
pages = [1,2,1,3,1,2]
maxCacheSize = 2

Output:
4

Explanation:
Cache state as requests come in ordered longest-time-in-cache to shortest-time-in-cache:
1*
1,2*
2,1
1,3*
3,1
1,2*

Asterisk (*) represents a cache miss. Hence, the total number of a cache miss is 4.
 */
public class LRUCacheMisses {
    public static void main(String[] args) {
        int num = 6;
        List pages = new ArrayList();
        pages.add(1);
        pages.add(2);
        pages.add(1);
        pages.add(3);
        pages.add(1);
        pages.add(2);
        pages.add(2);
        pages.add(2);
        pages.add(3);
        int maxCacheSize = 2;

        System.out.println("Tha value is "+ lruCacheMisses(num, pages, maxCacheSize));
        System.out.println("Tha value is "+ solve(num, pages, maxCacheSize));


    }
    // my solution
    private static int lruCacheMisses(int num, List<Integer> pages, int maxCacheSize) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int miss = 0;
        for (int page : pages) {
            if (!map.containsKey(page)) {
                map.put(page, 1);
                miss++;
            } else {
                map.remove(page);
                map.put(page, 1);
            }
            if (map.size() > maxCacheSize) {
                Map.Entry<Integer, Integer> entry = map.entrySet().iterator().next();
                map.remove(entry.getKey());
            }
        }
        return miss;
    }

    private static int solve(int num, List<Integer> pages, int maxCacheSize) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(maxCacheSize);
        int misses = 0;
        for (Integer page : pages) {
            if (cache.put(page, 0) == null) {
                misses++;
            }
        }
        return misses;
    }

    public static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private final int maxSize;

        public LRUCache(int maxSize) {
            super(16, 0.75f, true);
            this.maxSize = maxSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > maxSize;
        }
    }
}
