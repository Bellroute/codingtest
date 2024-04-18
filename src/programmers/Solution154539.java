package programmers;

import java.util.Stack;

// 프로그래머스 연습문제 - 뒤에 있는 큰 수 찾기
// https://school.programmers.co.kr/learn/courses/30/lessons/154539
public class Solution154539 {

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            int now = numbers[i];

            while (!stack.isEmpty()) {
                if (stack.peek()[1] < now) {
                    answer[stack.pop()[0]] = now;
                } else {
                    break;
                }
            }

            stack.add(new int[] {i, now});
        }

        while (!stack.isEmpty()) {
            int index = stack.pop()[0];
            answer[index] = -1;
        }

        return answer;
    }
}
