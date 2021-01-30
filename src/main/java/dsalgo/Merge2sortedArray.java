package dsalgo;

public class Merge2sortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};
        merge(arr1, arr2, arr1.length, arr2.length);
        for(int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+" ");
        }
        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]+" ");
        }
    }

    public static void merge(int arr1[], int arr2[], int n, int m) {
        // code here
        int i=n-1;
        int j = m-1;
        while(i>=0&&j>=0){
            if(arr2[j]>=arr1[i]){
                j--;
                continue;
            }
            int temp = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = temp;

            for(int k=i;k>=1;k--){
                if(arr1[k-1]<=arr1[k]){
                    break;
                }
                temp = arr1[k-1];
                arr1[k-1] = arr1[k];
                arr1[k] = temp;
            }
            for(int p=0;p<arr1.length;p++){
                System.out.print(arr1[p]+" ");
            }
            for(int p=0;p<arr2.length;p++){
                System.out.print(arr2[p]+" ");
            }
            System.out.println();
        }
    }
}
