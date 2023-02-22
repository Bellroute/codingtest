package programmers;

import java.util.*;

public class Solution154540 {

    private List<Integer> result;
    private char[][] grid;
    private boolean[][] visited;
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};

    public int[] solution(String[] maps) {
        result = new ArrayList<>();

        grid = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                grid[i][j] = maps[i].charAt(j);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'X' || visited[i][j]) {
                    continue;
                }

                bfs(i, j);
            }
        }

        int[] answer = new int[result.size()];

        Collections.sort(result);

        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        if (answer.length == 0) {
            return new int[] {-1};
        }

        return answer;
    }

    private void bfs(int x, int y) {
        int count = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            count += Integer.parseInt(String.valueOf(grid[now.x][now.y]));

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (!isInArea(nextX, nextY) || visited[nextX][nextY] || grid[nextX][nextY] == 'X') {
                    continue;
                }

                visited[nextX][nextY] = true;
                queue.offer(new Point(nextX, nextY));
            }
        }

        result.add(count);
    }

    private boolean isInArea(int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
