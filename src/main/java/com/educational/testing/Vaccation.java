package com.educational.testing;

import java.util.Scanner;

public class Vaccation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[][] dp = new int[3][n];
        dp[0][0] = a;
        dp[1][0] = b;
        dp[2][0] = c;
        for(int i=1;i<n;i++){
             a = sc.nextInt();
             b = sc.nextInt();
             c = sc.nextInt();
            dp[0][i] = a + Math.max(dp[1][i-1], dp[2][i-1]);
            dp[1][i] = b + Math.max(dp[0][i-1], dp[2][i-1]);
            dp[2][i] = c + Math.max(dp[1][i-1], dp[0][i-1]);
        }
        System.out.println(Math.max(dp[0][n-1],Math.max(dp[1][n-1],dp[2][n-1])));
    }
}
