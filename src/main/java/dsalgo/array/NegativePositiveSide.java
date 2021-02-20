package dsalgo.array;

public class NegativePositiveSide {
    public static void main(String[] args) {
        int[] arr = { -12, 11, -13, -5,
                6, -7, 5, -3, 11 };

        int arr_size = arr.length;

        // Function Call
        shiftall(arr, 0, arr_size - 1);
        display(arr, arr_size - 1);
    }

    private static void display(int[] arr, int len) {
        // Loop to iterate over the element
        // of the given array
        for(int i = 0; i <= len; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    private static void shiftall(int[] arr, int i, int i1) {
        int left = 0, right = arr.length-1;
        while(left<=right){
            if(arr[left]<0 && arr[right]<0){
                left++;
            }
            if(arr[left]<0 && arr[right]>0){
                left++;
                right--;
            }
            if(arr[left]>0 && arr[right]>0){
                right--;
            }
            if(arr[left]>0 && arr[right]<0){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
}
