package programmers;


import java.util.PriorityQueue;
import java.util.Queue;

class Solution155651 {
    public int solution(String[][] book_time) {
        int answer = 0;

        Queue<int[]> times = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        for (String[] book : book_time) {
            int start = parseTimeToMinute(book[0]);
            int end = parseTimeToMinute(book[1]);

            times.offer(new int[]{start, end + 10});
        }

        Queue<Integer> rooms = new PriorityQueue<>();

        while (!times.isEmpty()) {
            int[] time = times.poll();

            if (rooms.isEmpty()) {
                rooms.offer(time[1]);
                continue;
            }

            if (time[0] >= rooms.peek()) {
                rooms.poll();
            }
            rooms.add(time[1]);
        }

        return rooms.size();
    }

    private int parseTimeToMinute(String time) {
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        return hours * 60 + minutes;
    }
}