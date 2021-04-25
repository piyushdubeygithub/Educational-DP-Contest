package dsalgo.array;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public static void main(String[] args) {
        Integer[][] intervals= {
                {2, 6},
                {1, 3},
                {8, 10} };
        for (int i = 0; i < intervals.length; i++) {
            System.out.println(intervals[i][0]);
        }
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length; i++) {
            System.out.println(intervals[i][0]);
        }
        LinkedList<Integer[]> merged = new LinkedList<>();
        for (Integer[] interval: intervals){
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if(merged.isEmpty() || merged.getLast()[1]<interval[0]){
                merged.add(interval);
            }else{
                // otherwise, there is overlap, so we merge the current and previous
                // intervals.
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        for (Integer[] mergedInterval : merged){
            System.out.println(mergedInterval[0]+","+mergedInterval[1]);
        }
        //merged.toArray(new int[merged.size()][]);
    }
}
