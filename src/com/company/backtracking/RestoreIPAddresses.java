package com.company.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lindaliu on 2020-08-03.
 */


// reference: https://leetcode.com/problems/restore-ip-addresses/discuss/31109/Java-easy-to-read-backtracking-solution
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        String temp = "";
        backTracking(0, 4, result, new StringBuilder(), s);
        return result;
    }

    public void backTracking(int i, int dotsLeft, List<String> result, StringBuilder sb, String s) {
        if (dotsLeft == 0) {
            if (i == s.length()) {
                result.add(sb.toString());
            } else {
                return;
            }
        }
        for (int j = i; j < s.length() && j < i + 3; j++) {
            String subString = s.substring(i, j + 1);
            if (subString.charAt(0) == '0' && subString.length() > 1) {
                break;
            }
            if (Integer.valueOf(subString) < 256) {
                int len = sb.length();
                sb.append(subString);
                if (j != s.length() - 1) {
                    sb.append(".");
                }
                backTracking(j + 1, dotsLeft - 1, result, sb, s);
                sb.setLength(len);
            }
        }
    }
}
