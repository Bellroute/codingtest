package programmers;

import java.util.Arrays;

public class Solution172927 {

    int[][] staminas = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    int min;

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        min = Integer.MAX_VALUE;

        int count = Arrays.stream(picks).sum();

        dfs(0, 0, count, picks, minerals);

        return min;
    }

    private void dfs(int stamina, int now, int count, int[] picks, String[] minerals) {
        if (stamina > min) {
            return;
        }

        if (count == 0 || now >= minerals.length) {
            min = stamina;
            return;
        }

        for (int i = 0; i < picks.length; i++) {
            if (picks[i] == 0) {
                continue;
            }

            int nextStamina = stamina;

            for (int j = now; j < Math.min(now + 5, minerals.length); j++) {
                if (minerals[j].equals("diamond")) {
                    nextStamina += staminas[i][0];
                } else if (minerals[j].equals("iron")) {
                    nextStamina += staminas[i][1];
                } else if (minerals[j].equals("stone")) {
                    nextStamina += staminas[i][2];
                }
            }

            picks[i]--;
            dfs(nextStamina, Math.min(now + 5, minerals.length), count - 1, picks, minerals);
            picks[i]++;
        }
    }
}
