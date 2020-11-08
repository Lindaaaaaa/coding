package com.company.bfsAndDfs.bfs;

/**
 * Created by Lindaliu on 2020-11-07.
 */
import java.util.*;
public class KSimilarStrings {
    //Think of A as graph start, and B as graph end, find shortest distance btw A and B is BFS
    //Cannot try every swap Time limit
    // Trick is you can find when A.charAt(i)!=B.charAt(i), find char where A and B starts to differ
    // then try to find a char in A that can be swap to make this index equal in A and B
    // there are multiple index you can try on
    public int kSimilarity(String A, String B) {
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        seen.add(A);
        queue.add(A);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i =0; i< size; i++) {
                String current = queue.poll();
                if (current.equals(B)) {
                    return res;
                }
                int j = 0;
                while (j < current.length() && current.charAt(j) == B.charAt(j)){
                    j++;
                }
                for (int k = j+1; k< A.length(); k++) {
                    if (current.charAt(k) == B.charAt(j) && current.charAt(k) != B.charAt(k)) {
                        String newString = swap(j, k, current);
                        if (!seen.contains(newString)) {
                            queue.add(newString);
                            seen.add(newString);
                        }
                    }
                }
            }
            res++;
        }
        return res;
    }

    public String swap(int index1, int index2, String s) {
        char[] charArray = s.toCharArray();
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
        String str = new String(charArray);
        return str;
    }
}
