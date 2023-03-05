package boj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution18870 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int[] sortedNumbers = Arrays.stream(numbers).sorted().toArray();

        Map<Integer, Integer> map = new HashMap<>();
        int addition = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(sortedNumbers[i])) {
                addition++;
                continue;
            }

            map.put(sortedNumbers[i], i - addition);
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = map.get(numbers[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(answer[i])
                         .append(" ");
        }

        System.out.println(stringBuilder.toString().trim());
    }
}
