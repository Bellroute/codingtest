package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution169199 {

    private final char WALL = 'D';
    private final char ROBOT = 'R';
    private final char GOAL = 'G';

    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};

    public int solution(String[] board) {
        int x = -1;
        int y = -1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == ROBOT) {
                    x = i;
                    y = j;
                    continue;
                }

            }
        }

        return bfs(x, y, board);
    }

    private int bfs(int x, int y, String[] board) {
        boolean[][] visited = new boolean[board.length][board[0].length()];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0));

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            if (board[now.x].charAt(now.y) == GOAL) {
                return now.depth;
            }
            visited[now.x][now.y] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                while (isInArea(nextX, nextY, board) && board[nextX].charAt(nextY) != WALL) {
                    nextX += dx[i];
                    nextY += dy[i];
                }

                nextX -= dx[i];
                nextY -= dy[i];

                if (visited[nextX][nextY]) {
                    continue;
                }

                queue.add(new Point(nextX, nextY, now.depth + 1));
            }
        }

        return -1;
    }

    private boolean isInArea(int x, int y, String[] board) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length();
    }

    private static class Point {
        int x;
        int y;
        int depth;

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
