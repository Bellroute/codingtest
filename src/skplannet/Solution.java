package skplannet;

class Solution {
    public static int solution(int n, int m, int k) {
        if (m < n || n * k < m) {
            return 0;
        }

        if (n == m) {
            return 1;
        }

        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                for (int l = 1; l <= Math.min(j, k); l++) {
                    dp[i][j] += dp[i - 1][j - l];
                }
            }
        }

        return dp[n][m] & 1_000_007;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 6, 3));
        System.out.println(solution(10, 6, 5));

    }
}
