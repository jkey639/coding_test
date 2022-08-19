package baekjoon.step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579_2 {

    static Integer[] dp;
    static int[] score;

    public static void main(String[] args) throws IOException {
        //            6
        //      4           5
        //   2     3     3     4 >> 4 불가능(연속 3번 1계단) >> 위의 5는 한 가지 경우만 가능
        // 0   1 1   2 1   2 2   3
        // N번째 계단에 도달할 수 있는 점수의 경우 : Math.max(N-2번째 계단까지 누적 점수, N-3번째 계단까지 누적 점수 + N-1번째 계단 점수) + N번째 계단 점수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nCnt = Integer.parseInt(br.readLine());
        dp = new Integer[nCnt + 2];
        score = new int[nCnt + 2];

        for(int i = 1; i <= nCnt; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = score[0] = 0;
        dp[1] = score[1];

        System.out.println(recur(nCnt));
    }

    private static int recur(int nCnt) {

        if (nCnt == 2) {

            if (dp[3] == null) {

                dp[2] = score[1] + score[2];
            } else {

                dp[2] = score[2];
            }
        }

        if (dp[nCnt] == null) {
            // 값이 동적 할당되지 않은 경우에만 실행
            dp[nCnt] = Math.max(recur(nCnt - 2), recur(nCnt - 3) + score[nCnt - 1]) + score[nCnt];
        }

        return dp[nCnt];
    }
}
