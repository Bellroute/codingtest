package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Solution11053 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");

        int[] numbers = new int[n];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int answer = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i ; j++) {
                if (numbers[i] > numbers[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                answer = Math.max(answer, dp[i]);
            }
        }

        System.out.println(answer);
    }
}
