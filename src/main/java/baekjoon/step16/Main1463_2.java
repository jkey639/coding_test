package baekjoon.step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1463_2 {

    public static void main(String[] args) throws IOException {
        // 정수 N >> 1
        // 최소 연산 횟수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nN = Integer.parseInt(br.readLine());

        System.out.println(recur(nN));
    }

    private static int recur(int nInput) {

        int nCountReturn = 0;

        if (nInput != 1) {
            if (nInput % 6 == 0) {
                nCountReturn = Math.min(Math.min(recur(nInput / 3), recur(nInput / 2)), recur(nInput - 1)) + 1;
            } else if (nInput % 3 == 0) {
                nCountReturn = Math.min(recur(nInput / 3), recur(nInput - 1)) + 1;
            } else if (nInput % 2 == 0) {
                nCountReturn = Math.min(recur(nInput / 2), recur(nInput - 1)) + 1;
            } else {
                nCountReturn = recur(nInput - 1) + 1;
            }
        }

        return nCountReturn;
    }
}
