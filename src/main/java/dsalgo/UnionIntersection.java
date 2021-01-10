package dsalgo;

public class UnionIntersection {
    public static void main(String args[])
    {
        int arr1[] = { 1, 2, 4, 5, 6 };
        int arr2[] = { 2, 3, 5, 7 };
        int m = arr1.length;
        int n = arr2.length;
        boolean findUnion = true;
        boolean findIntersection = true;
        System.out.println("Union: ");
        printUnionIntersection(arr1, arr2, m, n, findUnion);
        System.out.println();
        if(findIntersection){
            findUnion = false;
            System.out.println("Intersection: ");
            printUnionIntersection(arr1, arr2, m, n, findUnion);
        }
        System.out.println();
    }

    private static void printUnionIntersection(int[] arr1, int[] arr2, int m, int n, boolean findUnion) {
     int i=0,j=0;
     while(i<m && j<n){
         if(arr1[i]<arr2[j]){
             if(findUnion){
                 System.out.print(arr1[i] +" ");
             }
             i++;
         }else if(arr2[j]<arr1[i]){
             if(findUnion){
                 System.out.print(arr2[j]+" ");
             }
             j++;
         }else {
             System.out.print(arr2[j]+" ");
             i++;
             j++;
         }
     }
     if(findUnion){
         while (i<m){
             System.out.print(arr1[i]+" ");
             i++;
         }
         while (j<n){
             System.out.print(arr2[j]+" ");
             j++;
         }
     }
    }
}
