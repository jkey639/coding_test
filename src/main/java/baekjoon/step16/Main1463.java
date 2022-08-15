package baekjoon.step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1463 {

    public static void main(String[] args) throws IOException {
        // 정수 N >> 1
        // 최소 연산 횟수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nN = Integer.parseInt(br.readLine());
        int nCount = getCountInOrder(nN);

        for (int i = 1; i <= nCount; i++) {
            nN -= 1;
            int nCountMinusFirst = getCountInOrder(nN) + i;
            if (nCountMinusFirst < nCount) {
                nCount = nCountMinusFirst;
            }
        }

        System.out.println(nCount);
        // >> 결과 : 3 또는 2로 나누어 떨어지면 무조건 나누는 연산을 실행해야 한다고 해석
        // 힌트에서 10의 경우에 10 -> 9 -> 3 -> 1로 3번 만에 만들 수 있다고 하는 것으로 보아 나누지 않고 1을 빼는 연산을 실행해도 무관한 것으로 보임
        // 따라서 위의 로직은 최소 횟수를 구하는 최적 로직이라고 할 수 없음
    }

    private static int getCountInOrder(int nN) {

        int nCountReturn = 0;

        while (true) {

            if (nN == 1) {
                break;
            } else if (nN % 6 == 0) {
                nN /= 6;
                nCountReturn += 2;
            } else if (nN % 3 == 0) {
                nN /= 3;
                nCountReturn += 1;
            } else if (nN % 2 == 0) {
                nN /= 2;
                nCountReturn += 1;
            } else {
                nN -= 1;
                nCountReturn += 1;
            }
        }

        return nCountReturn;
    }
    // >> 결과 : 1을 먼저 빼는 경우 외에 중간 중간 1을 선택하는 경우가 포함되지 않는 것으로 보임
}
