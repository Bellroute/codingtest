package skplannet;

class Solution3 {

    private final int WALL = 0;
    private final int CHARACTER = 2;
    private final int FLOWER = 3;

    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, 1, -1};

    private int[][] map;
    private boolean[][] visited;

    private boolean isAble = false;

    public int[] solution(String[][] boards) {

        int[] answer = new int[boards.length];
        int index = 0;

        for (String[] board : boards) {
            map = new int[board.length][board.length];

            int startX = 0;
            int startY = 0;

            visited = new boolean[board.length][board.length];

            int total = map.length * map[0].length;

            for (int i = 0; i < board.length; i++) {
                String row = board[i];

                for (int j = 0; j < row.length(); j++) {
                    map[i][j] = row.charAt(j) - '0';

                    if (map[i][j] == CHARACTER) {
                        startX = i;
                        startY = j;

                        map[startX][startY] = FLOWER;
                        visited[startX][startY] = true;
                    }

                    if (map[i][j] == WALL) {
                        total--;
                    }
                }

            }

            isAble = false;
            dfs(startX, startY, total - 1);

            if (isAble) {
                answer[index++] = 1;
                continue;
            }

            answer[index++] = 0;
        }

        return answer;
    }

    public void dfs(int x, int y, int totalCount) {

        if (isAble) {
            return;
        }

        if (totalCount == 0) {
            isAble = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (!isInArea(nextX, nextY)) {
                continue;
            }

            if (map[nextX][nextY] == WALL || map[nextX][nextY] == FLOWER) {
                continue;
            }

            if (visited[nextX][nextY]) {
                continue;
            }

            visited[nextX][nextY] = true;
            map[nextX][nextY] = 3;
            totalCount--;

            dfs(nextX, nextY, totalCount);

            visited[nextX][nextY] = false;
            map[nextX][nextY] = 1;
            totalCount++;
        }

    }

    private boolean isInArea(int x, int y) {
        return 0 <= x && x < map.length && 0 <= y && y < map.length;
    }
}