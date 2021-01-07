package designpatterns;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthMaxAndMin {
    public static void main(String[] args) {
        Integer arr[] = new Integer[] { 12, 3, 5, 7, 19 };
        int k = 2;
        System.out.print("K'th Largest element is " + kthLargest(arr, k));
        k=2;
        System.out.print("K'th smallest element is " + kthSmallest(arr, k));
    }

    private static int kthSmallest(Integer[] nums, int k) {
        PriorityQueue<Integer> maxHeap= new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums){
            maxHeap.add(i);
            if(maxHeap.size()>k){
                maxHeap.remove();
            }
        }
        return maxHeap.peek();
    }

    private static int kthLargest(Integer[] nums,int k){
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        for(int i:nums){
            minHeap.add(i);
            if(minHeap.size()>k){
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
}

