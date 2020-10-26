package com.company.backtracking;
import java.util.*;
/**
 * Created by Lindaliu on 2020-10-13.
 */
public class LetterCombinationsofaPhoneNumber {
    List<String> res = new LinkedList<>();
    Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length()==0) {
            return new ArrayList();
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(digits,"",0);
        return res;
    }

    public void helper(String digits, String current, int index) {
        if (current.length() == digits.length()) {
            res.add(current);
            return;
        }
        String s = map.get(digits.charAt(index));
        for (char c: s.toCharArray()) {
            helper(digits, current + c, index+1);
        }
    }

    // use string buffer

//    List<String> res = new LinkedList<>();
//    Map<Character, String> map = new HashMap<>();
//
//    public List<String> letterCombinations(String digits) {
//        if (digits.length()==0) {
//            return new ArrayList();
//        }
//        map.put('2', "abc");
//        map.put('3', "def");
//        map.put('4', "ghi");
//        map.put('5', "jkl");
//        map.put('6', "mno");
//        map.put('7', "pqrs");
//        map.put('8', "tuv");
//        map.put('9', "wxyz");
//        StringBuffer s = new StringBuffer();
//        helper(digits,s,0);
//        return res;
//    }
//
//    public void helper(String digits, StringBuffer current, int index) {
//        if (current.length() == digits.length()) {
//            res.add(current.toString());
//            return;
//        }
//        String s = map.get(digits.charAt(index));
//        for (char c: s.toCharArray()) {
//            helper(digits, current.append(c), index+1);
//            current.deleteCharAt(current.length()-1);
//        }
//    }
}

