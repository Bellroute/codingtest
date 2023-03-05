package boj;

import java.util.*;

public class Solution1927 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Queue<Integer> queue = new PriorityQueue<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());

            if (input == 0) {
                if (queue.isEmpty()) {
                    answer.add(0);
                    continue;
                }
                answer.add(queue.poll());
                continue;
            }

            queue.offer(input);
        }

        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }
}
