package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// 플5 - 백조의 호수
// https://www.acmicpc.net/problem/3197
public class Solution3197 {

    private static int R;
    private static int C;
    private static char[][] map;
    private static boolean[][] visited;
    private static Queue<int[]> wq, sq;
    private static int[] swan1;
    private static int[] swan2;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        wq = new LinkedList<>();
        sq = new LinkedList<>();

        R = Integer.parseInt(input.split(" ")[0]);
        C = Integer.parseInt(input.split(" ")[1]);

        int[] swan = new int[4];
        int index = 0;

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            input = scanner.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'L') {
                    swan[index++] = i;
                    swan[index++] = j;
                    map[i][j] = '.';
                }

                if (map[i][j] == '.') {
                    wq.add(new int[]{i, j});
                }
            }
        }

        swan1 = new int[]{swan[0], swan[1]};
        swan2 = new int[]{swan[2], swan[3]};
        visited = new boolean[R][C];
        visited[swan1[0]][swan1[1]] = true;
        sq.add(swan1);

        int result = 0;
        while (!isAbleToMeet()) {
            melt();
            result++;
        }

        System.out.println(result);
    }

    private static boolean isAbleToMeet() {
        Queue<int[]> queue = new LinkedList<>();

        while (!sq.isEmpty()) {
            int[] point = sq.poll();
            int px = point[0];
            int py = point[1];

            if (px == swan2[0] && py == swan2[1]) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (!isInArea(nx, ny) || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                if (map[nx][ny] == '.') {
                    sq.add(new int[]{nx, ny});
                    continue;
                }

                if (map[nx][ny] == 'X') {
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        sq = queue;
        return false;
    }

    private static boolean isInArea(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }

    private static void melt() {
        int size = wq.size();

        for (int i = 0; i < size; i++) {
            int[] point = wq.poll();

            for (int j = 0; j < 4; j++) {
                int nx = point[0] + dx[j];
                int ny = point[1] + dy[j];

                if (!isInArea(nx, ny)) {
                    continue;
                }

                if (map[nx][ny] == 'X') {
                    map[nx][ny] = '.';
                    wq.add(new int[] {nx, ny});
                }
            }
        }
    }
}
