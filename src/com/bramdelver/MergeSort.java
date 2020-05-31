package com.bramdelver;

public class MergeSort {

    private static final int CUTOFF = 7;

    public static void mergeSort(Comparable[] arrayToBeSorted) {
        Comparable[] copiedArray = new Comparable[arrayToBeSorted.length];
        sort(arrayToBeSorted, copiedArray, 0, arrayToBeSorted.length - 1);
    }

    /*
     * Sorts an array into an array of two sorted halves
     */
    private static void sort(Comparable[] arrayToBeSorted, Comparable[] copiedArray, int low, int high) {
        if (high <= low) {
            return;
        }
        if (high <= low + CUTOFF - 1) {
            InsertionSort.insertionSort(arrayToBeSorted, low, high);
        }
        int mid = low + ((high - low) / 2);
        sort(arrayToBeSorted, copiedArray, low, mid);
        sort(arrayToBeSorted, copiedArray, mid+1, high);
        if(!isLessThan(arrayToBeSorted[mid+1], arrayToBeSorted[mid])) {
            return;
        }
        merge(arrayToBeSorted, copiedArray, low, mid, high);
    }

    /*
     * Merges an array of two sorted halves
     */
    private static void merge(Comparable[] arrayToBeMerged, Comparable[]copiedArray, int low, int mid, int hi) {
        for(int i = low; i <= hi; i++) { // Copy array to be merged to auxiliary array
            copiedArray[i] = arrayToBeMerged[i];
        }

        int i = low, j = mid+1; // Set pointers to first element of each sorted half

        for(int k = low; k <= hi; k++) {
            if (i > mid) { // We've exhausted the first half
                arrayToBeMerged[k] = copiedArray[j++];
            } else if (j > hi) { // We've exhausted the right half
                arrayToBeMerged[k] = copiedArray[i++];
            } else if (isLessThan(copiedArray[i], copiedArray[j])) {
                arrayToBeMerged[k] = copiedArray[i++];
            } else {
                arrayToBeMerged[k] = copiedArray[j++];
            }
        }
    }

    public static boolean isLessThan(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
