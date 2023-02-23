package programmers;

import java.util.*;

public class Solution152995 {

    public int solution(int[][] scores) {
        int answer = 0;
        int[] target = scores[0];

        Arrays.sort(scores, (x, y) -> {
            if (x[0] == y[0]) {
                return x[1] - y[1];
            }
            return y[0] - x[0];
        });

        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < scores.length; i++) {
            boolean isDrop = false;

            if (temp < scores[i][1]) {
                temp = scores[i][1];
            } else if (temp > scores[i][1]) {
                isDrop = true;
            }

            if (isDrop) {
                if (scores[i][0] == target[0] && scores[i][1] == target[1]) {
                    return -1;
                }
                continue;
            }

            if (scores[i][0] + scores[i][1] > target[0] + target[1]) {
                answer++;
            }
        }

        return answer;
    }
}
