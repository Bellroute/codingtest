package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1504 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int INF = 200_000_000;

        int n = Integer.parseInt(input.split(" ")[0]);
        int e = Integer.parseInt(input.split(" ")[1]);

        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for (int i = 0; i < e; i++) {
            input = scanner.nextLine();
            int a = Integer.parseInt(input.split(" ")[0]);
            int b = Integer.parseInt(input.split(" ")[1]);
            int value = Integer.parseInt(input.split(" ")[2]);

            graph[a][b] = value;
            graph[b][a] = value;
        }

        input = scanner.nextLine();
        int v1 = Integer.parseInt(input.split(" ")[0]);
        int v2 = Integer.parseInt(input.split(" ")[1]);

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int result1 = graph[1][v1] + graph[v1][v2] + graph[v2][n];
        int result2 = graph[1][v2] + graph[v2][v1] + graph[v1][n];

        int answer = Math.min(result1, result2);
        if (answer >= INF) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }
}
