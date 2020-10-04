package com.AmazoOA;

import java.util.*;

/**
 * Created by Lindaliu on 2020-10-02.
 * https://leetcode.com/discuss/interview-question/542597/
 */
public class TopKMentionedKeyWords {
    public static void main(String[] args) {
        int k1 = 2;
        String[] keywords1 = { "anacell", "cetracular", "betacellular" };
        String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell", };
        int k2 = 2;
        String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
        String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services", "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
        System.out.println(solve(k1, keywords1, reviews1));
        System.out.println(solve(k2, keywords2, reviews2));


    }

    private static List<String> solve(int k, String[] keywords, String[] reviews) {
        Set<String> keyWordSet = new HashSet<>(Arrays.asList(keywords));
        Map<String, Integer> count = new HashMap<>();
        for (String r : reviews) {
            String[] review = r.split("\\W");
            Set<String> added = new HashSet<>();
            for (String reviewWord : review) {
                String s = reviewWord.toLowerCase();
                if (keyWordSet.contains(s) && !added.contains(s)) {
                    count.put(s, count.getOrDefault(s, 0) + 1);
                    added.add(s);
                }
            }
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> count.get(b) == count.get(a) ? b.compareTo(a) : count.get(a) - count.get(b));
        for (String s : count.keySet()) {
            pq.add(s);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
