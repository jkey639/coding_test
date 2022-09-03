package baekjoon.step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1463_2 {

    static Integer[] nResult;

    public static void main(String[] args) throws IOException {
        // 정수 N >> 1
        // 최소 연산 횟수
        // 정수 N에 대하여 연산 방법 3가지
        // 각 연산은 선택가능한 옵션이기 때문에, 3과 2 모두로 나누어 떨어질 경우를 고려해야 한다.
        // 따라서, 4가지 조건으로 분기
        // 1. 6으로 나누어 떨어지는 경우
        // 2. 3으로 나누어 떨어지는 경우
        // 3. 2로 나누어 떨어지는 경우
        // 4. 1로 빼는 경우
        // 예) 10 >> 2로 나누거나 1로 빼는 두 가지 경우로 연산할 수 있다.
        // 2로 나누면 5, 1로 빼면 9가 연산 결과. 두 수에 대해 또 다시 연산 조건을 적용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 동적계획법 결과 변수
        nResult = new Integer[n];
        nResult[0] = 0;
        // 정수 N까지 배열 요소로 초기화
        int[] na = new int[n];
        for (int i = 0; i < n; i++) {
            na[i] = i + 1;
        }

        System.out.println(recur(na[n - 1]));
    }

    private static int recur(int nInput) {

//        if (nInput > 1) {
        // 동적계획법 변수를 초기화한 지점까지 재귀함수를 마쳤을 경우
        if (nResult[nInput - 1] != null) {
            if (nInput % 6 == 0) {
                nResult[nInput - 1] = Math.min(Math.min(recur(nInput / 3), recur(nInput / 2)), recur(nInput - 1)) + 1;
            } else if (nInput % 3 == 0) {
                nResult[nInput - 1] = Math.min(recur(nInput / 3), recur(nInput - 1)) + 1;
            } else if (nInput % 2 == 0) {
                nResult[nInput - 1] = Math.min(recur(nInput / 2), recur(nInput - 1)) + 1;
            } else {
                nResult[nInput - 1] = recur(nInput - 1) + 1;
            }
        }

        return nResult[nInput - 1];
    }
}
