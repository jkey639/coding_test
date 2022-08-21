package leetcode.dp;

public class Solution91 {
}

class Solution91_submit {

    public int numDecodings(String s) {
        // 11106
        // 1. 1 1 10 6 >> AAJF
        // 2. 11 10 6 >> KJF
        // 유효하지 않음. 1 11 06 >> 06 != 6 >> F로 decode 할 수 없음
        // param : String s
        // return : int number(s를 decode할 수 있는 경우의 수)

        // 문자열을 자르는 방법은??
        // 숫자 1, 2 >> 일의 자리, 십의 자리 모두 가능
        // 숫자 3, 4, 5, 6 >> 일의 자리 조건 없이 가능 : 십의 자리가 없거나 1, 2인 경우 모두 가능
        // 숫자 7, 8, 9 >> 일의 자리 조건부 가능 : 십의 자리가 없거나 1인 경우
        // 숫자 0 >> 일의 자리 조건부 가능 : 십의 자리가 1, 2인 경우
        return recur(s);
    }

    private int recur(String s) {

        if ("".equals(s)) {

            return 0;
        }

        String strFst = s.substring(0, 1);
        if ("3".equals(strFst) || "4".equals(strFst) || "5".equals(strFst) || "6".equals(strFst)) {
            // return 1
            // param
            // recur(s.substring(1));
        } else if ("7".equals(strFst) || "8".equals(strFst) || "9".equals(strFst)) {
            // return 1
            // param
            // recur(s.substring(1)); >> 위 조건과 합칠 수 있음
        } else if ("0".equals(strFst)) {
            // 맨 앞이 0인 경우 자를 수 있는 경우가 없다.
            return 0;
        } else {
            // 1인 경우
            // 1. 한 글자로 자를 때 : 다음 수가 0이 아니면 가능
            // 2. 두 글자로 자를 때 : 모든 경우 가능
            // 2인 경우
            // 1. 한 글자로 자를 때 : 다음 수가 0이 아니면 가능
            // 2. 두 글자로 자를 때 : 다음 수가 0, 1, 2, 3, 4, 5, 6일 경우만 가능(7, 8, 9일 경우 불가능)
        }

        return 0;

        // 0만 먼저 생각할 필요가 없을 것 같다.
        /*
        int nZeroIdx = s.indexOf("0");
        if (nZeroIdx == 0) {

            // 자를 수 없는 경우의 수
            return 0;
        }

        if (nZeroIdx > 0) {
            // 1. 0을 기준으로 자른 결과 앞의 문자열 >> 다시 recur 함수
            // 2. 0 앞의 수 + 0을 디코딩
            // 3. 0을 기준으로 자른 결과 뒤의 문자열 >> 다시 recur 함수
//            s.substring(0, nZeroIdx - 1);
//            s.substring(nZeroIdx - 1, nZeroIdx + 1);
//            s.substring(nZeroIdx + 1);

            // 2번 디코딩 결과 값은 1개 확장 >> return 1;
            // 최종 return = 1 * 2 * 3(세 가지 경우의 수의 곱)
        }
        */
    }
}
