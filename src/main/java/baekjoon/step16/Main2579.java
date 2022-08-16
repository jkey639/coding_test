package baekjoon.step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579 {

    static Integer[] dp;
    static int[] score;

    public static void main(String[] args) throws IOException {
        // 계단 밟으면 점수 획득
        // 규칙
        // 1. 한 번에 한 계단 또는 두 계단
        // 2. 연속된 세 개의 계단을 밟아서는 안 된다
        // 3. 마지막 계단은 밟아야 한다
        // 입력 : 첫째 줄에 계단의 개수, 둘째 줄부터 제일 아래에 놓은 계단부터 순서대로 계단 점수

        // 경우의 수
        // 1. 한 계단 오르기
        // - 두 계단을 올라 마지막 계단을 지나칠 경우 한 계단을 올라야 한다.
        // 2. 두 계단 오르기
        // - 이 전 두 계단에서 한 계단씩 오른 경우 두 계단을 올라야 한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nCnt = Integer.parseInt(br.readLine());
        dp = new Integer[nCnt + 1];
        score = new int[nCnt + 1];
        score[0] = 0;
        for (int i = 1; i <= nCnt; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(recur(nCnt));
    }

    private static int recur(int nCnt) {

        if (dp[nCnt] != null) {
            if (nCnt == 1) {
                // 한 계단만 올라서 도달한 경우
                dp[nCnt] = recur(nCnt - 1) + score[nCnt];
            } else if (dp[nCnt - 3] != null && dp[nCnt - 2] != null) {
                // 두 계단만 올라서 도달한 경우
                dp[nCnt] = recur(nCnt - 2) + score[nCnt];
            } else {
                // 선택 가능한 경우
                dp[nCnt] = Math.max(recur(nCnt - 1) + score[nCnt], recur(nCnt - 2) + score[nCnt]);
            }
        }

        return dp[nCnt];
    }
}
