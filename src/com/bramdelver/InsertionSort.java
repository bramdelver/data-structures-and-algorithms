package com.bramdelver;

import static com.bramdelver.MergeSort.isLessThan;

public class InsertionSort {

    public static void insertionSort(Comparable[] toBeSorted, int low, int high) {
        for(int i = low; i < high; i++){
            for(int j = i; j > low; j--) {
                if (isLessThan(toBeSorted[j], toBeSorted[j - 1])) {
                    Comparable temp = toBeSorted[j - 1];
                    toBeSorted[j - 1] = toBeSorted[j];
                    toBeSorted[j] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
