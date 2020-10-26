package com.company.two_pointer;

/**
 * Created by Lindaliu on 2020-10-08.
 */
/* expend from middle, can either be a or aa, so make sure to call helper with begin=i and end=i, also
beign=i, end=i+1
O(n^2)
 */
public class LongestPalindromicSubstring {
    int resultStart;
    int resultLength;
    public String longestPalindrome(String s) {
        if (s.length()<2) {return s;}
        for(int i=0 ;i<s.length(); i++) {
            helper(s, i, i);
            helper(s, i,  i+1);
        }
        return s.substring(resultStart, resultLength + resultStart);
    }

    public void helper(String s, int begin, int end) {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)){
            begin--;
            end++;
        }
        if (end-begin-1> resultLength){
            resultLength = end-begin-1;
            resultStart = begin+1;
        }
    }
}
