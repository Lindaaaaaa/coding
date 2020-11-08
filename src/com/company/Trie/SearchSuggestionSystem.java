package com.company.Trie;
import java.util.*;
/**
 * Created by Lindaliu on 2020-11-04.
 */
public class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new LinkedList<>();
        PriorityQueue<String> pq = new PriorityQueue<>((s1,s2) ->s2.compareTo(s1));
        for (int i=1; i<= searchWord.length(); i++) {
            for (String product: products) {
                String t = searchWord.substring(0, i);
                if (product.startsWith(t)) {
                    pq.offer(product);
                    if (pq.size() > 3) {
                        pq.poll();
                    }
                }
            }
            LinkedList<String> temp = new LinkedList<>();
            while (pq.size()!=0) {
                temp.addFirst(pq.poll());
            }
            res.add(temp);
        }
        return res;
    }
}
