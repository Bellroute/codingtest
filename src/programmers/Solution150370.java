package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution150370 {

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();

        int todayToDay = changeDateToDay(today);

        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            termMap.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String date = privacy.split(" ")[0];
            String term = privacy.split(" ")[1];

            if (todayToDay < changeDateToDay(date) + termMap.get(term) * 28) {
                continue;
            }
            result.add(i + 1);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private int changeDateToDay(String date) {
        int year = Integer.parseInt(date.split("\\.")[0]);
        int month = Integer.parseInt(date.split("\\.")[1]);
        int day = Integer.parseInt(date.split("\\.")[2]);

        return year * 12 * 28 + month * 28 + day;
    }
}
