package com.company.two_pointer;

/**
 * Created by Lindaliu on 2020-07-05.
 * find max height [h[0]...h[i]], find max height [h[i] ... h[n-1]]
 * warter unit is min(maxLeft, maxRight - original height of i
 */
public class TrappingRainWater {
    // dynamic user creation can optimize finding max to the left and to the right
    public int trap(int[] height) {
        int n = height.length;
        if (n== 0) {
            return 0;
        }
        int[] leftMaxHeight = new int[n];
        int[] rightMaxHeight = new int[n];
        leftMaxHeight[0] = height[0];
        rightMaxHeight[n-1] = height[n-1];
        for (int i =1; i< n; i++) {
            leftMaxHeight[i] = Math.max(leftMaxHeight[i-1], height[i]);
            rightMaxHeight[n-i-1] = Math.max(rightMaxHeight[n-i], height[n-i-1]);
        }
        int[] res = new int[n];
        int total = 0;
        for (int j = 0; j<n; j++) {
            res[j] = Math.min(leftMaxHeight[j], rightMaxHeight[j]) - height[j];
            total += res[j];
        }
        return total;
    }
    // two pointer solution
    //https://www.youtube.com/watch?v=XqTBrQYYUcc
}
