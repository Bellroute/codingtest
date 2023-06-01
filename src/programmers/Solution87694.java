package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution87694 {

    private final int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    private final int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    private boolean[][] map;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        int answer = 0;

        map = new boolean[104][104];
        for (int[] rect : rectangle) {
            int x1 = rect[1] * 2;
            int y1 = rect[0] * 2;
            int x2 = rect[3] * 2;
            int y2 = rect[2] * 2;

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2 ; j++) {
                    map[i][j] = true;
                }
            }
        }

        for (int[] rect : rectangle) {
            int x1 = rect[1] * 2;
            int y1 = rect[0] * 2;
            int x2 = rect[3] * 2;
            int y2 = rect[2] * 2;

            for (int i = x1 + 1; i < x2; i++) {
                for (int j = y1 + 1; j < y2 ; j++) {
                    map[i][j] = false;
                }
            }
        }

        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<Point> queue = new PriorityQueue<>();

        queue.add(new Point(characterY * 2, characterX * 2, 0));
        visited[characterY * 2][characterX * 2] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == itemY * 2 && now.y == itemX * 2) {
                answer = now.depth;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (!isInArea(nextX, nextY) || visited[nextX][nextY]) {
                    continue;
                }

                if (!map[nextX][nextY]) {
                    continue;
                }

                visited[nextX][nextY] = true;
                queue.add(new Point(nextX, nextY, now.depth + 1));
            }
        }

        return answer / 2;
    }

    private boolean isInArea(int x, int y) {
        return 0 <= x && x < 104 && 0 <= y && y < 104;
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
