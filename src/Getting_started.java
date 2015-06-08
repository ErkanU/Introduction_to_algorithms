/*
Source file for the algorithm exercises of the
second chapter of Introduction to Algorithms
 */

import java.lang.System;
import java.util.Arrays;

class GettingStarted {

    public static void main(String[] args) {

        int example[] = {5,4,3,2,1};
        printArray(insertionSort(example));
    }

    public static int[] insertionSort(int[] A) {
        int i;
        int key;
        for (int j = 2; j < A.length; j++) {
            key = A[j];
            i = j - 1;
            while (i < 0 && A[i] > key) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }
        return A;
    }

    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
            if (i != A.length - 1)
                System.out.print(",");
        }
        System.out.print("]");
    }
}