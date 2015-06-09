import java.lang.Math;

public class MergeSort {

    public int[] A;
    private int[] L;
    private int[] R;
    private int[] copy;

    public void sort(int[] values, String method) {
        this.A = values;
        mergeSort(0, this.A.length - 1, method);
    }

    private void mergeSort(int p, int r, String method) {
        // System.out.println("Merge sort " + p + " " + r);
        int q;
        if (p < r) {
            q = (int) Math.floor((p + r)/2.0);
            mergeSort(p, q, method);
            mergeSort(q + 1, r, method);
            if (method.equals("sentinel")) {
                mergeSentinel(p, q, r);
            } else {
                mergeCopied(p, q, r);
            }

        }
    }

    private void mergeSentinel(int p, int q, int r) {
        // System.out.println("Merge sentinel " + p + " " + q + " " + r);
        int n_1 = q - p + 1;
        int n_2 = r - q;
        int i;
        int j;

        L = new int[n_1 + 1];
        R = new int[n_2 + 1];

        for (i = 0; i < n_1; i++) {
            L[i] = A[p + i];
        }
        for (j = 0; j < n_2; j++) {
            R[j] = A[q + j + 1];
        }
        L[n_1] = Integer.MAX_VALUE;
        R[n_2] = Integer.MAX_VALUE;


        i = 0;
        j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }

    }

    private void mergeCopied(int p, int q, int r) {
        // System.out.println("Merge copied " + p + " " + q + " " + r);
        int copy[] = this.A;
        int left = p;
        int right = q + 1;
        int k = p;
        while (left <= q && right <= r) {
            if (copy[left] <= copy[right]) {
                A[k] = copy[left];
                left++;
            } else {
                A[k] = copy[right];
                right++;
            }
            k++;
        }
    }
}
