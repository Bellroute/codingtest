package skplannet;

import java.util.Arrays;

public class Solution4 {

    private int answer = 0;

    public int solution(int n, int m, int k) {

        if (m < n || n * k < m) {
            return 0;
        }

        if (n == m) {
            return 1;
        }

        int count = m - n;
        k -= 1;

        int[] temp = new int[n];
        dfs(0, count, temp, k);

        return answer % 1_000_007;
    }

    private void dfs(int index, int count, int[] temp, int limit) {
        if (count == 0) {
            Arrays.stream(temp).forEach(x -> System.out.print(x + " "));
            System.out.println();
            answer += 1;
            return;
        }

        for (int i = index; i < temp.length; i++) {
            if (temp[i] + 1 > limit) {
                continue;
            }

            temp[i] += 1;
            dfs(i, count -1, temp, limit);
            temp[i] -= 1;
        }
    }
}
