package dsalgo.array;

import java.util.Arrays;

public class RotateArray {
    static int arr[] = new int[]{1, 2, 3, 4, 5};

    public static void main(String[] args) {
        System.out.println("Given Array is");
        System.out.println(Arrays.toString(arr));
        rotate();
        System.out.println("Rotated Array is");
        System.out.println(Arrays.toString(arr));
    }

    private static void rotate() {
        int n = arr.length;
        int x = arr[n-1];
        for(int i=n-1;i>0;i--){
            arr[i] = arr[i-1];
        }
        arr[0] = x;
    }
}
