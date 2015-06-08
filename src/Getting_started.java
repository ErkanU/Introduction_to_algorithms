/*
Source file for the algorithm exercises of the
second chapter of Introduction to Algorithms
 */

import java.lang.System;
import java.util.Arrays;

class GettingStarted {

    public static void main(String[] args) {

        // Q2.1-1
        System.out.println("==== Insertion sort ====");
        int example[] = {31,41,59,26,41,58};
        printArray(insertionSort(example));

        // Q2.1-2
        System.out.println("==== Decreasing Insertion sort ====");
        printArray(decreasingInsertionSort(example));

        // Q2.1-4
        System.out.println("==== Adding Binary integers ====");
        int A[] = {1,0,0,1,0,1};
        int B[] = {1,1,0,0,1,1};
        printArray(addBinaryInteger(A, B));

    }

    public static int[] insertionSort(int[] A) {
        int i;
        int key;
        for (int j = 1; j < A.length; j++) {
            key = A[j];
            i = j - 1;
            while (i >= 0 && A[i] > key) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }
        return A;
    }

    public static int[] decreasingInsertionSort(int[] A) {
        int i;
        int key;
        for (int j = A.length - 2; j >= 0; j--) {
            key = A[j];
            i = j + 1;
            while (i < A.length && A[i] > key) {
                A[i - 1] = A[i];
                i++;
            }
            A[i - 1] = key;
        }
        return A;
    }

    // we suppose that the arrays only contain 1s and 0s
    // the binary number is read from left to right (reverse)
    public static int[] addBinaryInteger(int[] A, int[] B) {
        if (A.length != B.length) {
            System.out.println("A and B must have the same size");
            return null;
        }

        int[] C = new int[A.length + 1];
        int remainder = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) {
                if (remainder == 1) {
                    C[i] = 0;
                    remainder = 1;
                } else {
                    C[i] = 1;
                    remainder = 0;
                }
            } else {
                if (A[i] == 1) {
                    if (remainder == 1) {
                        C[i] = 1;
                    } else {
                        C[i] = 0;
                    }
                    remainder = 1;
                } else {
                    C[i] = remainder;
                    remainder = 0;
                }
            }
        }
        C[C.length - 1] = remainder;
        return C;
    }

    public static void printArray(int[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
            if (i != A.length - 1)
                System.out.print(",");
        }
        System.out.println("]");
    }
}