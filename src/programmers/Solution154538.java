package programmers;

import java.util.Arrays;

public class Solution154538 {

    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        int MAX = 1_000_004;
        Arrays.fill(dp, MAX);
        dp[x] = 0;

        for (int i = x + 1; i < y + 1; i++) {
            int min = MAX;
            if (x <= i - n) {
                min = Integer.min(min, dp[i - n]);
            }

            if (i % 2 == 0 && x <= i / 2) {
                min = Integer.min(min, dp[i / 2]);
            }

            if (i % 3 == 0 && x <= i / 3) {
                min = Integer.min(min, dp[i / 3]);
            }

            dp[i] = Integer.min(min + 1, MAX);
        }

        Arrays.stream(dp).forEach(a -> System.out.print(a + " "));
        if (dp[y] < MAX) {
            return dp[y];
        }


        return -1;
    }
}
