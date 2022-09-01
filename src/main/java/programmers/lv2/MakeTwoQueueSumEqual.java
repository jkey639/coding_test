package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class MakeTwoQueueSumEqual {

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};
        System.out.println(s.solution(queue1, queue2));
    }
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
        System.out.println("q1 : " + q1);
        System.out.println("q2 : " + q2);
        System.out.println("q1_ori : " + q1_ori);
        System.out.println("q2_ori : " + q2_ori);

        answer = 0;
        /**
         * 반복문 실행을 줄이는 방법을 찾아보자.
         * 반복문 내부에서 실행되는 로직 중에 반복문 외부에서 변수로 저장하여 사용할 수 있는 방법을 최대한 활용
         * 현재 반복문 로직 점검
         * 1. 무한 반복
         * 2. 1번 큐와 2번 큐 각각의 합을 비교하여 합이 큰 큐에서 요소를 꺼내 합이 작은 큐로 옮긴다.
         *  2.1. 반복문 내 반복문으로 외부 반복문은 두 큐의 합 크기가 전환되는 한 사이클을 범위로 한다.
         * 3. 이 사이클은 두 큐 합이 같거나 두 큐 요소가 서로 바뀌어서 동일한 요소를 갖게되었을 때 완전히 종료한다.
         */
        while (true) {

            while (n1Sum < n2Sum) {

                int n2Poll = q2.poll();
                n2Sum -= n2Poll;
                q1.add(n2Poll);
                n1Sum += n2Poll;
                answer++;
            }
            System.out.println("n1Sum : " + n1Sum);

            while (n1Sum > n2Sum) {

                int n1Poll = q1.poll();
                n1Sum -= n1Poll;
                q2.add(n1Poll);
                n2Sum += n1Poll;
                answer++;
            }
            System.out.println("n2Sum : " + n2Sum);

            if (n1Sum == n2Sum) {
                break;
            }

            // q1과 q2 요소가 교환되므로 q1은 q2_ori와 q2는 q1_ori와 비교해야 한다.
            if ((q1.equals(q2_ori) && q2.equals(q1_ori)) || (q1.isEmpty() || q2.isEmpty())) {
                answer = -1;
                break;
            }
        }

        return answer;
    }
}