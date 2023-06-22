package programmers;

public class Solution150368 {

    private final int[] DISCOUNT_RATES = {10, 20, 30, 40};
    private int[] answer;

    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];

        dfs(0, new int[emoticons.length], users, emoticons);

        return answer;
    }

    private void dfs(int depth, int[] rates, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            int[] cost = new int[emoticons.length];
            for (int i = 0; i < emoticons.length; i++) {
                cost[i] = emoticons[i] / 100 * (100 - DISCOUNT_RATES[rates[i]]);
            }

            int count = 0;
            int total = 0;

            for (int[] user : users) {
                int sum = 0;
                for (int i = 0; i < emoticons.length; i++) {
                    if (user[0] <= DISCOUNT_RATES[rates[i]]) {
                        sum += cost[i];
                    }
                }

                if (user[1] <= sum) {
                    count++;
                } else {
                    total += sum;
                }
            }

            if (answer[0] < count) {
                answer[0] = count;
                answer[1] = total;
            } else if (answer[0] == count) {
                answer[1] = Math.max(answer[1], total);
            }

            return;
        }

        for (int i = 0; i <= 3; i++) {
            rates[depth] += i;
            dfs(depth + 1, rates, users, emoticons);
            rates[depth] -= i;
        }
    }
}
