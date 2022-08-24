package leetcode.dp;

public class Solution91_2 {

    public static void main(String[] args) {

        Solution91_2_submit s = new Solution91_2_submit();
        System.out.println(s.numDecodings("110"));
    }
}

class Solution91_2_submit {

    static Integer[] dp;

    public int numDecodings(String s) {
        // 11106
        // 1. 1 1 10 6 >> AAJF
        // 2. 11 10 6 >> KJF
        // 유효하지 않음. 1 11 06 >> 06 != 6 >> F로 decode 할 수 없음
        // param : String s
        // return : int number(s를 decode할 수 있는 경우의 수)

        // 문자열을 자르는 경우의 수??
        // 한 글자 혹은 두 글자를 붙여 제시받은 문자열을 만드는 방법
        // (문자열 - 1) + 1 : 한 글자를 붙이는 경우의 수
        // (문자열 - 2) + 2 : 두 글자를 붙이는 경우의 수
        // >> 경우의 수 = 마지막 한 글자를 뺀 문자열 경우의 수 + 마지막 두 글자를 뺀 문자열 경우의 수
        int nLen = s.length();
        dp = new Integer[nLen + 1];
        dp[0] = 1; // 함수 내에서 붙일 수 있는 문자 조건을 구분하므로 empty string에 붙이는 경우는 무조건 가능하다.
        // 두 글자를 자르는 경우의 수가 곧 붙이는 두 글자의 경우의 수와 같으므로 함수로 구현 >> recur()

        return recur(s, nLen);
    }

    private int recur(String s, int nLen) {
        // s-1 경우의 수 + s-2 경우의 수
        // s-1 경우의 수 : 마지막에 붙이는 한 글자가 가능해야 한다.
        // s-2 경우의 수 : 마지막에 붙이는 두 글자가 가능해야 한다.
        // 00 ~ 99
        // 00 ~ 09 : 한 글자, 두 글자 모두 불가능
        // 10 ~ 26 : 한 글자, 두 글자 모두 가능(10, 20은 한 글자 불가능)
        // 26 ~ 99 : 한 글자만 가능(30, 40, 50, ..., 90은 모두 불가능)

        // 0으로 시작하거나 00이 포함되어 있으면 불가능
        if (s.startsWith("0") || s.contains("00")) {

            dp[nLen] = 0;
        }

        if (dp[nLen] == null) {

//            String strMol = s.substring(0, nLen - 1);
//            String strMtl = s.substring(0, nLen - 2);
//            String strTl = s.substring(nLen - 2);
            String strMol = s.substring(1);
            String strMtl = s.substring(2);
            String strTl = s.substring(0, 2);
//            System.out.println(strMol);
//            System.out.println(strMtl);
//            System.out.println(strTl);
            int nTl = Integer.parseInt(strTl);
            if (nTl <= 9) {
                // 가능 경우
                // X
                dp[nLen] = 0;
            } else if (nTl <= 26) {

                if (nTl == 10 || nTl == 20) {
                    // 두 글자
//                    dp[nLen] = dp[nLen - 2];
                    dp[nLen] = recur(strMtl, nLen - 2);
                } else {
                    // 한 글자, 두 글자
                    dp[nLen] = recur(strMol, nLen - 1) + recur(strMtl, nLen - 2);
                }
            } else {

                if (strTl.endsWith("0")) {
                    // X
                    dp[nLen] = 0;
                } else {
                    // 한 글자
                    dp[nLen] = recur(strMol, nLen - 1);
                }
            }
        }

//        System.out.println("s : " + s);
//        System.out.println("nLen : " + nLen);
//        System.out.println("dp[nLen] : " + dp[nLen]);
        return dp[nLen];
    }
}
