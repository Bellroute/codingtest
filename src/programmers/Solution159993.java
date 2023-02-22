package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution159993 {

    private final char START = 'S';
    private final char END = 'E';
    private final char LEVER = 'L';
    private final char PATH = 'O';
    private final char WALL = 'X';

    private char[][] maze;

    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};

    public int solution(String[] maps) {
        int answer = 0;
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];

        maze = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                maze[i][j] = maps[i].charAt(j);
                if (maze[i][j] == START) {
                    start[0] = i;
                    start[1] = j;
                    continue;
                }

                if (maze[i][j] == LEVER) {
                    lever[0] = i;
                    lever[1] = j;
                    continue;
                }

                if (maze[i][j] == END) {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        int distance = getShortestDistance(start, lever);
        if (distance == -1) {
            return -1;
        }
        answer += distance;

        distance = 0;
        distance = getShortestDistance(lever, end);
        if (distance == -1) {
            return -1;
        }
        answer += distance;

        return answer;
    }

    private int getShortestDistance(int[] start, int[] goal) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        Queue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == goal[0] && now.y == goal[1]) {
                return now.depth;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (!isInArea(nextX, nextY)) {
                    continue;
                }

                if (maze[nextX][nextY] == WALL) {
                    continue;
                }

                if (visited[nextX][nextY]) {
                    continue;
                }

                visited[nextX][nextY] = true;
                queue.add(new Point(nextX, nextY, now.depth + 1));
            }
        }

        return -1;
    }

    private boolean isInArea(int x, int y) {
        return 0 <= x && x < maze.length && 0 <= y && y < maze[0].length;
    }

    class Point implements Comparable<Point> {
        int x;
        int y;

        int depth;

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

        @Override
        public int compareTo(Point o) {
            return this.depth - o.depth;
        }
    }
}
