package dsalgo.array;

public class KadaneWithAllNegativeElements {
    public static void main(String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = a.length;
        int max_sum = maxSubArraySum(a, n);
        System.out.println("Maximum contiguous sum is "
                + max_sum);
    }

    private static int maxSubArraySum(int[] a, int n) {
        int max_so_far = a[0];
        int max_ending_here = a[0];
        for(int i=1;i<n;i++){
            max_ending_here = Math.max(a[i], max_ending_here+a[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }
}
