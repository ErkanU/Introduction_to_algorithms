/*
Source file for the algorithm exercises of the
fourth chapter of Introduction to Algorithms
 */

public class DivideAndConquer {

    public static void main(String[] args) {

        // 4-1.5
        int example[] = {-5, 7, 8, -12, 3, -2, 9};
        System.out.println(maximumSubarray(example));
    }

    // maximum subarray algorithm by Kadane, O(n) complexity
    public static int maximumSubarray(int[] A) {

        int max_so_far = 0;
        int max_ending_here = 0;
        for(int i = 0; i < A.length; i++) {
            max_ending_here = max_ending_here + A[i];
            if(max_ending_here < 0)
                max_ending_here = 0;
            if(max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
        return max_so_far;
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
