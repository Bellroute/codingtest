package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution159994 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";

        Queue<String> cardQueue1 = new LinkedList<>();
        for (String card : cards1) {
            cardQueue1.offer(card);
        }

        Queue<String> cardQueue2 = new LinkedList<>();
        for (String card : cards2) {
            cardQueue2.offer(card);
        }

        for (String word : goal) {
            if (!cardQueue1.isEmpty() && word.equals(cardQueue1.peek())) {
                cardQueue1.poll();
                continue;
            }

            if (!cardQueue2.isEmpty() && word.equals(cardQueue2.peek())) {
                cardQueue2.poll();
                continue;
            }

            return "No";
        }

        return "Yes";
    }
}
