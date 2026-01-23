class Solution {

    public static int[][] map;
    public static int lenX, lenY;

    public int solution(int[][] beginning, int[][] target) {
        int answer = 0;

        lenX = beginning.length;
        lenY = beginning[0].length;
        map = new int[lenX][lenY];

        // beginning과 target 비교해서 같으면 1, 다르면 0
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                map[i][j] = (beginning[i][j] == target[i][j]) ? 1 : 0;
            }
        }

        // 첫 번째 행에서 1의 개수 세기
        int cnt = 0;
        for (int i = 0; i < lenY; i++) {
            if (map[0][i] == 1) cnt++;
        }

        boolean flag = (lenY / 2 > cnt);

        // 열 뒤집기
        for (int i = 0; i < lenY; i++) {
            if (flag) {
                if (map[0][i] == 1) {
                    changeY(i);
                    answer++;
                }
            } else {
                if (map[0][i] == 0) {
                    changeY(i);
                    answer++;
                }
            }
        }

        // 필요하면 첫 번째 행 뒤집기
        if (flag) {
            changeX(0);
            answer++;
        }

        // 나머지 행 처리
        for (int i = 1; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                if (map[i][j] == 0) {
                    changeX(i);
                    answer++;
                }
            }
        }

        // 전부 1인지 확인
        if (!count()) answer = -1;

        return answer;
    }

    public void changeX(int line) {
        for (int i = 0; i < lenY; i++) {
            map[line][i] = (map[line][i] + 1) % 2;
        }
    }

    public void changeY(int line) {
        for (int i = 0; i < lenX; i++) {
            map[i][line] = (map[i][line] + 1) % 2;
        }
    }

    public boolean count() {
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }
}
