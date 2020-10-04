package com.AmazoOA;

/**
 * Created by Lindaliu on 2020-09-28.
 */

/* let's say for person j, there are l ppl who have rating smaller than j, r ppl who have rating bigger than j
put j in the middle , number of combination is l*j, for rating[i]<rating[j]<rating[k]. There are (j-l)ppl who are bigger than
j sitting on his left, and (n-1-j-r) ppl on the right
 */
public class countNumberOfTeams {
    public int numTeams(int[] rating) {
        int res = 0;
        for (int i = 0; i < rating.length; i++) {
            int l = 0;
            int r = 0;
            for (int k = 0; k < i; k++) {
                if (rating[k] < rating[i]) {
                    l++;
                }
            }
            for (int m = i + 1; m < rating.length; m++) {
                if (rating[m] > rating[i]) {
                    r++;
                }
            }
            res += r * l + (i - l) * (rating.length - 1 - r - i);
        }
        return res;
    }
}
