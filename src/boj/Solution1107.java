package boj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution1107 {

    private static Set<Integer> numbers;
    private static int answer;
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());

        numbers = new HashSet<>();
        if (m != 0) {
            String[] inputs = scanner.nextLine().split(" ");
            for (String input : inputs) {
                numbers.add(Integer.parseInt(input));
            }
        }

        answer = Math.abs(n - 100);
        if (n == 100) {
            System.out.println(0);
            return;
        }

        dfs("");
        System.out.println(answer);
    }

    private static void dfs(String number) {
        for (int i = 0; i < 10; i++) {
            if (numbers.contains(i)) {
                continue;
            }

            String nextNumber = number + i;
            answer = Math.min(answer, Math.abs(n - Integer.parseInt(nextNumber)) + nextNumber.length());

            if (number.length() >= 6) {
                continue;
            }
            dfs(nextNumber);
        }
    }
}
