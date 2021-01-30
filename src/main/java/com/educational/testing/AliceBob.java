package com.educational.testing;

import java.util.HashMap;
import java.util.Scanner;

public class AliceBob {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr = sc.nextLine();
        String[] str = arr.split(" ");
        int[] a = new int[str.length];
        int sum = 0;
        for(int i=0;i<str.length;i++){
            a[i] = Integer.parseInt(str[i].trim());
            sum +=a[i];
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(countMap.containsKey(a[i])){
                int count = countMap.get(a[i]);
                count++;
                countMap.put(a[i], count);
            }else{
                countMap.put(a[i], 1);
            }
        }
        int max = 0;
        for(Integer key: countMap.keySet()){
            int val = key* countMap.get(key);
            if(val>max){
                max = val;
            }
        }
        int ans = sum-max;
        System.out.println(ans);
    }
}
