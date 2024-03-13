package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 2022 KAKAO TECH INTERNSHIP - 두 큐 합 같게 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/118667
public class Solution118667 {

    public int solution(int[] queue1, int[] queue2) {
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();

        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }

        long targetSum = (sum1 + sum2) / 2;
        Queue<Integer> q1 = new LinkedList<>();
        Arrays.stream(queue1).forEach(q1::add);
        Queue<Integer> q2 = new LinkedList<>();
        Arrays.stream(queue2).forEach(q2::add);

        for (int i = 0; i < q1.size() * 3; i++) {
            if (sum1 == targetSum) {
                return i;
            }

            if (q1.isEmpty() || q2.isEmpty()) {
                break;
            }

            if (sum1 < targetSum) {
                int pop = q2.poll();
                sum2 -= pop;
                q1.add(pop);
                sum1 += pop;
                continue;
            }

            int pop = q1.poll();
            sum1 -= pop;
            q2.add(pop);
            sum2 += pop;
        }

        return -1;
    }
}
