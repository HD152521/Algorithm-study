import java.util.*;

class Solution {

    int[] dx = {0, 1, 0, -1}; // 우, 하, 좌, 상
    int[] dy = {-1, 0, 1, 0}; // 위, 오른쪽 기준 좌표
    int width, height;
    boolean[][][] visit;
    String[] grid;

    public int[] solution(String[] grid) {
        this.grid = grid;
        height = grid.length;
        width = grid[0].length();
        visit = new boolean[height][width][4]; // y, x, 방향

        List<Integer> answerList = new ArrayList<>();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                for (int dir = 0; dir < 4; dir++) {
                    if (!visit[y][x][dir]) {
                        int len = move(x, y, dir);
                        if (len > 0) answerList.add(len);
                    }
                }
            }
        }

        Collections.sort(answerList); // 오름차순 정렬
        return answerList.stream().mapToInt(i -> i).toArray();
    }

    // 방향 이동 함수
    public int move(int x, int y, int dir) {
        int count = 0;

        while (true) {
            if (visit[y][x][dir]) break;
            visit[y][x][dir] = true;
            count++;

            // 현재 셀의 문자 확인 후 방향 전환
            char cell = grid[y].charAt(x);
            if (cell == 'L') dir = (dir + 3) % 4; // 좌회전: -1 (mod 4)
            else if (cell == 'R') dir = (dir + 1) % 4; // 우회전: +1 (mod 4)

            // 좌표 이동 (토러스 형태라 격자 벗어나면 반대쪽으로)
            x = (x + dx[dir] + width) % width;
            y = (y + dy[dir] + height) % height;
        }

        return count;
    }
}
