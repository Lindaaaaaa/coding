package com.company;

import com.AmazoOA.LRUCacheMisses;

import java.util.*;
/**
 Given the number of five-star and total reviews for each product a company sells, as well as the threshold percentage, what is the minimum number of additional five-star reviews the company needs to become five star seller.
 For ex, there are 3 products (n=3) with productRatings =[[4,4],[1,2],[3,6]], percentage rating threshold = 77.
 [1,2] indicates => [1 (five star reviews) ,2 (total reviews)].
 We need to get the seller reach the threshold with minimum number of additional five star reviews.

 Before we add more five star reviews, the percentage for this seller is ((4/4) + (1/2) + (3/6))/3 = 66.66%
 If we add a five star review to 2nd product, ((4/4) + (2/3) + (3/6))/3 = 72.22%
 If we add another five star review to 2nd product, ((4/4) + (3/4) + (3/6))/3 = 75%
 If we add a five star review to 3rd product, ((4/4) + (3/4) + (4/7))/3 = 77.38%
 At this point, 77% (threshold) is met. Therefore, answer is 3 (because that is the minimum five star reviews we need to add, to get the seller reach the threshold).

 Constraints:
 1<= productRatings.size() <=200
 In product ratings, [fivestar, total], fivestar <=100, total<=100
 1<=ratingsThreshold< 100
 productRatings contains only non negative integers.*/

public class Main {
    public static void main(String[] args) {
        String test = "awaglknagawunagwkwagl";
        String[] input = new String[] { "345366 89921 45", "029323 38239 23", "38239 345366 15", "029323 38239 77",
                "345366 38239 23", "029323 345366 13", "38239 38239 23" };
        System.out.println(solve(test, 4));


    }
    public static Set<String> solve(String s, int k) {
        Set<String> res = new HashSet<>();
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0, j =0; j<s.length(); j++) {
            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j),j);
            } else {
                i = Math.max(map.get(s.charAt(j))+1, i);
                map.put(s.charAt(j),j);
            }
            if (j-i+1==k) {
                res.add(s.substring(i,j+1));
                i++;
            }
        }
        return res;
    }
}

