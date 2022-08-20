package leetcode.string;

public class Solution242 {
}

class Solution {
    public boolean isAnagram(String s, String t) {
        // s와 t로 만든 char 배열 비교 시 이중 for문
        // 임의의 배열을 하나 만든 뒤 해당 배열에 s에서 사용되는 알파벳 개수를 저장
        // 해당 배열에서 t에서 사용되는 알파벳을 다시 비교하여 동일한 개수의 알파벳이 사용되었는지 확인
        int[] naApb = new int[26];

        int nSLen = s.length();
        int nTLen = t.length();

        if (nSLen != nTLen) {

            return false;
        }

        for (int i = 0; i < s.length(); i++) {

            naApb[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {

            naApb[t.charAt(i) - 'a']--;
        }

        for (int nElm : naApb) {

            if (nElm != 0) {

                return false;
            }
        }

        return true;
    }
}
