import java.io.*;
import java.util.*;

class Shark {
    int x, y, dir;
    boolean isAlive = true;
    int[][] priority = new int[5][5];
    public Shark(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
class Main {
    static int n, m, k, answer = 0;
    static int[][][] map;
    static Shark[] shark;
    static int[] disX = {0, -1, 1, 0, 0};
    static int[] disY = {0, 0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken()); // 격자칸
        m = Integer.parseInt(st.nextToken()); // 상어 마리수
        k = Integer.parseInt(st.nextToken()); // 냄새 시간

        // 격자
        map = new int[n][n][2];
        shark = new Shark[m+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num != 0) {
                    shark[num] = new Shark(i, j);
                    map[i][j][0] = num; // 상어 냄새 뿌리기
                    map[i][j][1] = k;
                }
            }
        }

        // 상어 초기 방향
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= m; i++) {
            shark[i].dir = Integer.parseInt(st.nextToken());
        }

        // 각각의 상어 방향 우선순위
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 1; k <= 4; k++) {
                    int dir = Integer.parseInt(st.nextToken());
                    shark[i].priority[j][k] = dir;
                }
            }
        }

        move();
        System.out.println(answer);
    }

    public static void move() {

        // 빠진 상어
        int outShark = m;

        // 상어 이동
        while (answer <= 1000) {
            if (outShark == 1 && shark[1].isAlive) {
                // 상어가 한 마리 남았을 때
                return;
            }
            answer++;
            for (int i = 1; i <= m; i++) {
                Shark s = shark[i];
                boolean flag = false;
                int tempX = 0;
                int tempY = 0;
                int tempDir = 0;
                int[] moveDir = s.priority[s.dir];

                // 빠진 상어는 패스
                if (!s.isAlive) continue;

                // 우선 방향 찾기
                for (int j = 1; j <= 4; j++) {
                    int ndir = moveDir[j];

                    int nx = s.x + disX[ndir];
                    int ny = s.y + disY[ndir];

                    //경계
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                    //냄새나는 칸
                    if (map[nx][ny][1] != 0) {
                        //해당 상어 냄새가 아닐 경우
                        if (map[nx][ny][0] != i) {
                            continue;
                        } else if (!flag){
                            // 해당 상어 냄새일 경우
                            flag = true;
                            tempX = nx;
                            tempY = ny;
                            tempDir = ndir;
                            continue;
                        }
                        continue;
                    }
                    // 아무 냄새 안나는 칸
                    flag = false;
                    s.x = nx;
                    s.y = ny;
                    s.dir = ndir;
                    break;

                }
                if (flag) {
                    // 갈 곳이 없으므로 내 냄새가 나는 칸으로 이동
                    s.x = tempX;
                    s.y = tempY;
                    s.dir = tempDir;
                }

            }
            // 냄새 시간 줄이기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j][1] > 0) {
                        if (--map[i][j][1] <= 0) {
                            // 냄새 시간이 지나면 없애기
                            map[i][j][0] = 0;
                        }
                    }
                }
            }

            // 겹친 상어 내보내기
            for (int i = m; i >= 1; i--) {
                Shark s = shark[i];
                if (!s.isAlive) continue;
                for (int j = 1; j < i; j++) {
                    Shark compare = shark[j];
                    if (!compare.isAlive) continue;
                    if (s.x == compare.x && s.y == compare.y) {
                        s.isAlive = false;
                        outShark--;
                        break;
                    }
                }
            }

            // 모든 상어 향기 뿌리기
            for (int i = 1; i <= m; i++) {
                Shark s = shark[i];
                if (!s.isAlive) continue;
                map[s.x][s.y][0] = i;
                map[s.x][s.y][1] = k;
            }

        }
        answer = -1;
    }
}