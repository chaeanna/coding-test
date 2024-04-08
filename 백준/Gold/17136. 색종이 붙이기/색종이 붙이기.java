import java.io.*;
import java.util.*;

class Main {
    static int[][] map = new int[10][10];
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        DFS(0, 0, 0);
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);
    }

    public static void DFS(int x, int y, int cnt) {
        // 끝까지 도달하면 answer, cnt 비교
        if (x >= 9 && y > 9) {
            answer = Math.min(answer, cnt);
            return;
        }

        // 기존 answer < cnt 일경우 리턴
        if (answer <= cnt) {
            return;
        }

        // 한 줄 도달
        if (y > 9) {
            DFS(x+1, 0, cnt);
            return;
        }

        // 색종이 붙여보기
        if (map[x][y] == 1) {
            for (int i = 5; i >= 1; i--) {
                if (paper[i] > 0 && isAttach(x, y, i)) {
                    // 색종이 붙이기
                    Attach(x, y, i, 0);
                    paper[i]--;
                    // 다음으로 이동
                    DFS(x, y + 1, cnt + 1);
                    // 색종이 떼기
                    Attach(x, y, i, 1);
                    paper[i]++;
                }
            }
        } else {
            DFS(x, y+1, cnt);
        }


    }

    public static void Attach(int x, int y, int size, int state) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = state;
            }
        }
    }

    public static boolean isAttach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                // map 범위 넘어설 경우
                if (i < 0 || i >= 10 || j < 0 || j >= 10) {
                    return false;
                }
                // 1이 적힌 칸이 아닐 경우
                if (map[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
}