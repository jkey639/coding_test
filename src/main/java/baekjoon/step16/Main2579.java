package baekjoon.step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579 {

    static Integer[] dp;
    static int[] score;

    public static void main(String[] args) throws IOException {
        //            6
        //      4           5
        //   2     3     3     4 >> 4 불가능(연속 3번 1계단) >> 위의 5는 한 가지 경우만 가능
        // 0   1 1   2 1   2 2   3
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nCnt = Integer.parseInt(br.readLine());
        dp = new Integer[nCnt + 2];
        score = new int[nCnt + 2];
        dp[0] = score[0] = 0;

        for(int i = 1; i <= nCnt; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(recur(nCnt));
    }

    private static int recur(int nCnt) {

        if (nCnt == 0) {
            return dp[0];
        } else {

            // return dp[nCnt];
            if (nCnt == 1) {

                dp[nCnt] = score[nCnt];
            } else if (dp[nCnt + 1] != null) {

                dp[nCnt] = recur(nCnt - 2) + score[nCnt];
            } else {

                dp[nCnt] = Math.max(recur(nCnt - 2), recur(nCnt - 1)) + score[nCnt];
            }
        }

        System.out.println(nCnt);
        return dp[nCnt];
    }
}
