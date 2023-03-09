package boj;

import java.util.Scanner;

public class Solution16953 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int a = Integer.parseInt(input.split(" ")[0]);
        int b = Integer.parseInt(input.split(" ")[1]);

        int count = 1;
        while (a != b) {
            if (b < a) {
                System.out.println(-1);
                return;
            }

            if (b % 10 == 1) {
                b /= 10;
                count++;
                continue;
            }

            if (b % 2 == 0) {
                b /= 2;
                count++;
                continue;
            }

            System.out.println(-1);
            return;
        }

        System.out.println(count);
    }
}
