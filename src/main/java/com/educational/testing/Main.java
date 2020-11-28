package com.educational.testing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        long[] w = new long[n];
        long[] v = new long[n];
        for(int i=0;i<n;i++){
            w[i] = sc.nextLong();
            v[i] = sc.nextLong();
        }
        long[][] dp = new long[n+1][W+1];
        for(int i=0;i<=n;i++){
            dp[0][i] = 0;
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
                if(w[i-1]>j){
                  dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][(int) (j-w[i-1])]+v[i-1]);
                }
            }
        }
        System.out.println(dp[n][W]);
    }
}
