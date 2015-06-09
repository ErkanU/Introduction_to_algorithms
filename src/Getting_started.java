/*
Source file for the algorithm exercises of the
second chapter of Introduction to Algorithms
 */

import java.lang.System;
import java.util.HashMap;

class GettingStarted {

    public static void main(String[] args) {

        int example_insertion[] = {31,41,59,26,41,58};
        int example_merge[] = {3, 41, 52, 26, 38, 57, 9, 49};
        int example_sum[] = {2,7,6,4,2,1,9};

        // Q2.1-1
        System.out.println("==== Insertion sort ====");
        printArray(insertionSort(example_insertion));

        // Q2.1-2
        System.out.println("==== Decreasing Insertion sort ====");
        printArray(decreasingInsertionSort(example_insertion));

        // Q2.1-4
        System.out.println("==== Adding Binary integers ====");
        int A[] = {1,0,0,1,0,1};
        int B[] = {1,1,0,0,1,1};
        printArray(addBinaryInteger(A, B));

        // Q2.2-2
        System.out.println("==== Selection sort ====");
        printArray(selectionSort(example_insertion));

        // 2.3-1
        System.out.println("==== Merge sort using sentinel method ====");
        MergeSort sorter_sentinel = new MergeSort();
        sorter_sentinel.sort(example_merge, "sentinel");
        printArray(selectionSort(sorter_sentinel.A));

        // 2-3.2
        System.out.println("==== Merge sort using copy method ====");
        MergeSort sorter_copied = new MergeSort();
        sorter_copied.sort(example_merge, "copied");
        printArray(selectionSort(sorter_copied.A));

        // 2-3.7 -- we could have sorted the array and done a dichotomic search
        System.out.println("==== Existence of two elements whose sum is x ====");
        findElementsSum(example_sum, 3);

    }

    // ====================== INSERTION AND SELECTION SORT ====================

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

    public static int[] selectionSort(int[] A) {
        int argmin;
        int temp;
        for (int i = 0; i < A.length - 1; i++) {
            argmin = i;
            for (int j = i + 1; j <= A.length - 1; j++) {
                if (A[j] < A[argmin]) {
                    argmin = j;
                }
            }
            temp = A[i];
            A[i] = A[argmin];
            A[argmin] = temp;
        }
        return A;
    }

    public static void findElementsSum(int[] A, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }
        for (int elmt : A) {
            if (map.containsKey(x - elmt)) {
                System.out.println("(" + elmt + ", " + A[map.get(x - elmt)] + ")");
                break;
            }
        }
    }

    // ============= Utilities ================

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