package skplannet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution1 {
    public int solution(String[] bakery_schedule, String current_time, int k) {
        int answer = -1;
        int now = parseTimeToMinute(current_time);

        List<int[]> bakerySchedule = new ArrayList<>();

        for (String schedule : bakery_schedule) {
            int time = parseTimeToMinute(schedule.split(" ")[0]);
            int count = Integer.parseInt(schedule.split(" ")[1]);

            bakerySchedule.add(new int[] {time, count});
        }

        bakerySchedule.sort(Comparator.comparingInt(o -> o[0]));

        int left = 0;
        int right = bakerySchedule.size();
        int start = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (bakerySchedule.get(mid)[0] < now) {
                left++;
                continue;
            }

            if (bakerySchedule.get(mid)[0] > now) {
                right--;
                continue;
            }

            start = mid;
            break;
        }

        if (start == -1) {
            start = left;
        }

        int count = 0;
        for (int i = start; i < bakerySchedule.size(); i++) {
            count += bakerySchedule.get(i)[1];

            if (count >= k) {
                answer = bakerySchedule.get(i)[0] - now;
                break;
            }
        }

        return answer;
    }

    private int parseTimeToMinute(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);

        return hour * 60 + minute;
    }
}
