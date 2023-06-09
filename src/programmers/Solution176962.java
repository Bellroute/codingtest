package programmers;

import java.util.*;

public class Solution176962 {

    public static String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();

        Queue<Task> queue = new PriorityQueue<>();
        for (String[] plan : plans) {
            queue.offer(new Task(plan[0], parseTimeToMinute(plan[1]), Integer.parseInt(plan[2])));
        }

        Stack<Task> lastTasks = new Stack<>();
        Task now = queue.poll();

        while (!queue.isEmpty()) {
            Task next = queue.peek();
            int gap =  next.startTime - (now.startTime + now.remainingTime);
            if (gap >= 0) {
                answer.add(now.name);
                now = queue.poll();

                while (!lastTasks.isEmpty()) {
                    if (lastTasks.peek().remainingTime > gap) {
                        lastTasks.peek().remainingTime -= gap;
                        break;
                    }

                    Task last = lastTasks.pop();
                    gap -= last.remainingTime;
                    answer.add(last.name);
                }

                continue;
            }

            now.remainingTime = Math.abs(gap);
            lastTasks.push(now);
            now = queue.poll();
        }

        answer.add(now.name);

        while (!lastTasks.isEmpty()) {
            answer.add(lastTasks.pop().name);
        }

        return answer.toArray(new String[0]);
    }

    private static int parseTimeToMinute(String time) {
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);

        return hours * 60 + minutes;
    }

    static class Task implements Comparable<Task> {
        String name;
        int startTime;
        int remainingTime;

        public Task(String name, int startTime, int lastTime) {
            this.name = name;
            this.startTime = startTime;
            this.remainingTime = lastTime;
        }

        @Override
        public int compareTo(Task o) {
            return this.startTime - o.startTime;
        }
    }

    public static void main(String[] args) {
        String[] answer = solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}});
        Arrays.stream(answer).forEach(System.out::println);
    }
}
