package com.bramdelver;

import edu.princeton.cs.algs4.StdRandom;

/*
 * Quick Sort implementation using Dijkstra's 3-way partitioning
 */
public class QuickSort {

    private static final int CUTOFF = 10;

    public static void quickSort(Comparable[] toBeSorted) {
        StdRandom.shuffle(toBeSorted); // Random shuffle of the array
        sort(toBeSorted, 0, toBeSorted.length);
        InsertionSort.insertionSort(toBeSorted, 0, toBeSorted.length); // Final pass with insertion sort
    }

    private static void sort(Comparable[] toBeSorted, int low, int high) {
        if (high <= low) {
            return;
        }

        // If the size of the (sub-)array <= 10, we let insertion sort deal with it
        if (high <= low + CUTOFF - 1) {
            return;
        }

        // Dijkstra's 3-way partition
        int i = low, lt = low, gt = high;
        Comparable partitionElement = toBeSorted[i];
        while (i <= gt) {
            int compare = toBeSorted[i].compareTo(partitionElement);
            if (compare < 0) {
                swap(toBeSorted, lt++, i++);
            } else if (compare > 0) {
                swap(toBeSorted, i, gt--);
            } else {
                i++;
            }
        }

        sort(toBeSorted, low, lt - 1);
        sort(toBeSorted, gt + 1, high);
    }

    /*
     * Swaps two elements in an array
     */
    private static void swap(Comparable[] array, int firstIndex, int secondIndex) {
        Comparable temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
