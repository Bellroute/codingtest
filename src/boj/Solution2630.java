package boj;

import java.util.Scanner;

public class Solution2630 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int n = Integer.parseInt(input);

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            input = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        int white = 0;
        int blue = 0;


    }
}
