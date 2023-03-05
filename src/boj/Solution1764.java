package boj;

import java.util.*;

public class Solution1764 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);

        Set<String> targets = new HashSet<>();
        for (int i = 0; i < n; i++) {
            targets.add(scanner.nextLine());
        }

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String target = scanner.nextLine();
            if (targets.contains(target)) {
                answer.add(target);
            }
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
