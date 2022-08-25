package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class MakeTwoQueueSumEqual {
}

class Solution {

    public int solution(int[] queue1, int[] queue2) {

        int answer = -2;

        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();

        int nAllSum = 0;
        int n1Sum = 0;
        for (int n1 : queue1) {
            q1.add(n1);
            nAllSum += n1;
            n1Sum += n1;
        }

        int n2Sum = 0;
        for (int n2 : queue2) {
            q2.add(n2);
            nAllSum += n2;
            n2Sum += n2;
        }

        if (nAllSum % 2 != 0) {
            return -1;
        } else if (n1Sum == n2Sum) {
            return 0;
        }

        Queue<Integer> q1_ori = new LinkedList<Integer>();
        Queue<Integer> q2_ori = new LinkedList<Integer>();
        q1_ori.addAll(q1);
        q2_ori.addAll(q2);

        if (n1Sum < n2Sum) {

            while (true) {

                while (n1Sum < n2Sum) {

                    int n2Poll = q2.poll();
                    n2Sum -= n2Poll;
                    q1.add(n2Poll);
                    n1Sum += n2Poll;
                }

                while (n1Sum > n2Sum) {

                    int n1Poll = q1.poll();
                    n1Sum -= n1Poll;
                    q2.add(n1Poll);
                    n2Sum += n1Poll;
                }

                if (n1Sum == n2Sum) {
                    break;
                }

                // q1과 q2 요소가 교환되므로 q1은 q2_ori와 q2는 q1_ori와 비교해야 한다.
                if (q1.equals(q2_ori) && q2.equals(q1_ori)) {
                    break;
                }
            }
        }

        return answer;
    }
}