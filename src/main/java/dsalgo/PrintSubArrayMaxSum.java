package dsalgo;

public class PrintSubArrayMaxSum {
    public static void main(String[] args) {
        int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int n = a.length;
        maxSubArraySum(a, n);
    }

    private static void maxSubArraySum(int[] a, int n) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;
        int start = 0, end = 0;
        for(int i=0;i<n;i++){
            max_ending_here += a[i];
            if(max_ending_here<0){
                max_ending_here = 0;
                start = i+1;
            }else if(max_ending_here>max_so_far){
                max_so_far = max_ending_here;
                end = i;
            }
        }
        System.out.println("Maximum contiguous sum is "
                + max_so_far);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }
}
