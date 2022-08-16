package baekjoon.step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579 {

    static Integer[] dp;
    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nCnt = Integer.parseInt(br.readLine());
        dp = new Integer[nCnt + 1];
        score = new int[nCnt + 1];
        score[0] = 0;

        for(int i = 1; i <= nCnt; ++i) {
            score[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(recur(nCnt));
    }

    private static int recur(int nCnt) {
        if (dp[nCnt] != null) {
            if (nCnt == 1) {
                dp[nCnt] = recur(nCnt - 1) + score[nCnt];
            } else if (dp[nCnt - 3] != null && dp[nCnt - 2] != null) {
                dp[nCnt] = recur(nCnt - 2) + score[nCnt];
            } else {
                dp[nCnt] = Math.max(recur(nCnt - 1) + score[nCnt], recur(nCnt - 2) + score[nCnt]);
            }
        }

        return dp[nCnt];
    }
}
