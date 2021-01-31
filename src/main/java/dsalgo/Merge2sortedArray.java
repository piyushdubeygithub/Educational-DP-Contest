package dsalgo;

import java.util.Arrays;
import java.util.OptionalInt;

public class Merge2sortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};
        merge2(arr1, arr2, arr1.length, arr2.length);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }

    /*
    * tc: O(m+n)
    * Suppose we have a number A and we want to
convert it to a number B and there is also a
constrain that we can recover number A any
time without using other variable.To achieve
this we chose a number N which is greater
than both numbers and add B*N int A.
so A --> A+B*N

To get number B out of (A+B*N)
we devide (A+B*N) by N (A+B*N)/N = B.

To get number A out of (A+B*N)
we take modulo with N (A+B*N)%N = A.

-> In short by taking modulo
we get old number back and taking divide
we new number.
    * */
    public static void merge2(int arr1[], int arr2[], int m, int n) {
        int max = 0;
        OptionalInt max1 = Arrays.stream(arr1).max();
        if (max1.isPresent()) {
            max = max1.getAsInt();
        }
        //actually it is max2
        max1 = Arrays.stream(arr2).max();
        if (max1.isPresent() && max1.getAsInt() > max) {
            max = max1.getAsInt();
        }
        // to avoid collision of 0
        max++;
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            int e1 = arr1[i] % max;
            int e2 = arr2[j] % max;
            if (e1 < e2) {
                int min = e1;
                if (k < m) {
                    arr1[k] += max * min;
                } else {
                    arr2[k - m] += max * min;
                }
                i++;
                k++;
            } else {
                int min = e2;
                if (k < m) {
                    arr1[k] += max * min;
                } else {
                    arr2[k - m] += max * min;
                }
                j++;
                k++;
            }
        }
        while (i < m) {
            int min = arr1[i] % max;
            if (k < m) {
                arr1[k] += max * min;
            } else {
                arr2[k - m] += max * min;
            }
            i++;
            k++;
        }
        while (j < n) {
            int min = arr2[j] % max;
            if (k < m) {
                arr1[k] += max * min;
            } else {
                arr2[k - m] += max * min;
            }
            j++;
            k++;
        }
        for (int p = 0; p < m; p++) {
            arr1[p] = arr1[p] / max;
        }
        for (int p = 0; p < n; p++) {
            arr2[p] = arr2[p] / max;
        }
    }

    /*
     * time complexity: O(m+n)
     *
     * */
    public static void merge1(int arr1[], int arr2[], int m, int n) {
        int gap = (m + n + 1) / 2;
        while (gap > 0) {
            for (int i = 0; i < arr1.length; i++) {
                System.out.print(arr1[i] + " ");
            }
            for (int i = 0; i < arr2.length; i++) {
                System.out.print(arr2[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < (m + n - gap); i++) {
                if ((i < arr1.length) && ((i + gap) < arr1.length)) {
                    if (arr1[i] > arr1[i + gap]) {
                        int temp = arr1[i];
                        arr1[i] = arr1[i + gap];
                        arr1[i + gap] = temp;
                    }
                } else if ((i >= arr1.length) && ((i + gap - arr1.length) < arr2.length)) {
                    if (arr2[i - arr1.length] > arr2[i + gap - arr1.length]) {
                        int temp = arr2[i - arr1.length];
                        arr2[i - arr1.length] = arr2[i + gap - arr1.length];
                        arr2[i + gap - arr1.length] = temp;
                    }
                } else if ((i < arr1.length) && ((i + gap - arr1.length) < arr2.length)) {
                    if (arr1[i] > arr2[i + gap - arr1.length]) {
                        int temp = arr1[i];
                        arr1[i] = arr2[i + gap - arr1.length];
                        arr2[i + gap - arr1.length] = temp;
                    }
                }
            }
            if (gap != 1) {
                gap = (gap + 1) / 2;
            } else {
                gap = gap / 2;
            }
        }
    }

    /*
     * time complexity O(m*n)
     * */
    public static void merge(int arr1[], int arr2[], int n, int m) {
        // code here
        int i = n - 1;
        int j = m - 1;
        while (i >= 0 && j >= 0) {
            if (arr2[j] >= arr1[i]) {
                j--;
                continue;
            }
            int temp = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = temp;

            for (int k = i; k >= 1; k--) {
                if (arr1[k - 1] <= arr1[k]) {
                    break;
                }
                temp = arr1[k - 1];
                arr1[k - 1] = arr1[k];
                arr1[k] = temp;
            }
            for (int p = 0; p < arr1.length; p++) {
                System.out.print(arr1[p] + " ");
            }
            for (int p = 0; p < arr2.length; p++) {
                System.out.print(arr2[p] + " ");
            }
            System.out.println();
        }
    }
}
