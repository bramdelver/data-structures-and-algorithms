package com.bramdelver;

import java.util.Arrays;

public class ThreeSum {

    public static int threeSum(int[] arr, int target) {
        int count = 0;
        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 1; i++){
            int a = arr[i];
            int start = i+1;
            int end = arr.length - 1;
            while (start < end) {
                int b = arr[start];
                int c = arr[end];
                if (a + b + c == target) {
                    count++;
                    start++;
                    end--;
                } else if (a + b + c > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return count;
    }
}
