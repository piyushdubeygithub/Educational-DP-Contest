package com.educational.testing;

import java.util.Scanner;

public class Frog2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] h = new int[n];
        for(int i=0;i<n;i++){
            h[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=k;j++){
           if(i-j>=0){
               dp[i] = Math.min(dp[i], dp[i-j] + Math.abs(h[i] - h[i-j]));
           }else{
               break;
           }
         }
        }
        System.out.println(dp[n-1]);
    }
}
