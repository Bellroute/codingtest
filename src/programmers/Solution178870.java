package programmers;

// 연습문제 / 리코쳇 로봇
// https://school.programmers.co.kr/learn/courses/30/lessons/169199?language=java
class Solution178870 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[] {0, sequence.length};

        int start = 0;
        int end = 0;
        int sum = sequence[0];

        while (end < sequence.length - 1) {
            if (sum == k) {
                if (start == end) {
                    return new int[] {start, end};
                }

                if (answer[1] - answer[0] > end - start) {
                    answer[0] = start;
                    answer[1] = end;
                }

                sum += sequence[++end];
                continue;
            }

            if (sum < k) {
                sum += sequence[++end];
                continue;
            }

            sum -= sequence[start++];
        }

        while (start <= end) {
            if (sum == k) {
                if (start == end) {
                    return new int[] {start, end};
                }

                if (answer[1] - answer[0] > end - start) {
                    answer[0] = start;
                    answer[1] = end;
                }
            }

            if (sum > k) {
                sum -= sequence[start++];
                continue;
            }

            break;
        }

        return answer;
    }
}