package com.educational.testing;

import java.util.ArrayList;
import java.util.HashMap;

public class ZeroSum {
    public static void main(String[] args) {
        int[] a = new int[]{-2,0,2,3,-3,4,-7};
        int n = a.length;
        ArrayList<Pair> zeroList =   getZeroSubarrays(a, n);
        printList(zeroList, a);
    }

    private static void printList(ArrayList<Pair> zeroList, int[] a) {
        for(int i=0;i<zeroList.size();i++){
            Pair p = zeroList.get(i);
            int start = p.first;
            int end = p.second;
            for(int j=start;j<=end;j++){
                System.out.print(a[j]+" ");
            }
            System.out.println();
        }
    }

    public static ArrayList<Pair> getZeroSubarrays(int[] a, int n){
        HashMap<Integer, ArrayList<Integer>> sumMap = new HashMap<>();
        ArrayList<Pair> zeroList = new ArrayList<>();
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += a[i];
            if(sum == 0){
                Pair pair = new Pair(0, i);
                zeroList.add(pair);
//                ArrayList<Integer> list = sumMap.get(0);
//                if(list == null){
//                    list = new ArrayList<>();
//                }
//                list.add(i);
            }
            if(sumMap.containsKey(sum)){
                ArrayList<Integer> list = sumMap.get(sum);
                for(Integer j: list){
                    Pair p = new Pair(j+1, i);
                    zeroList.add(p);
                }
                list.add(i);
                sumMap.put(sum, list);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                sumMap.put(sum, list);
            }
        }
        return zeroList;
    }
}

class Pair{
    int first, second;
    public Pair(int a, int b){
        first = a;
        second = b;
    }
}
