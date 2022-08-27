package leetcode.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution20 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Solution20_submit obj = new Solution20_submit();
        obj.isValid(s);
    }
}

class Solution20_submit {

    public boolean isValid(String s) {
        // {'(', ')', '{', '}', '[', ']'}
        // ( >> 0
        // ) >> 1
        // { >> 2
        // } >> 3
        // [ >> 4
        // ] >> 5
        if (s.length() % 2 != 0) {

            return false;
        }

        String strChar = "(){}[]";
        String[] saChar = s.split("");
        // {"{", "[", "]", "}"}
        int[] naDx = new int[s.length()];

        for (int i = 0; i < saChar.length; i++) {

            naDx[i] = strChar.indexOf(saChar[i]) / 2;

            if (i % 2 == 1) {

                if (naDx[i] != naDx[i - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
