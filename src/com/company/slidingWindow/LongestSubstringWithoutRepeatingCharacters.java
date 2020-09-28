package com.company.slidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lindaliu on 2020-08-03.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s==null ||s.length()==0){
            return 0;
        }
        int result = 1;
        for(int i=0; i <s.length(); i++){
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            int localLength = 1;
            for (int j = i+1; j <s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    localLength+=1;
                    result = Math.max(result, localLength);
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public int lengthOfLongestSubstring_slidingWindow(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int answer = 1;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                answer = Math.max(j - i + 1, answer);
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return answer;
    }
}
