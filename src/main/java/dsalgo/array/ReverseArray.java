package dsalgo.array;

public class ReverseArray {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,7,11,4,89};
        int start = 0, end = a.length-1;
        while(start<end){
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
