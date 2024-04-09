import java.io.*;
import java.util.*;

class Fish {
    int idx, x, y, dir;
    boolean isAlive = true;

    public Fish(int idx, int x, int y, int dir, boolean isAlive) {
        this.idx = idx;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.isAlive = isAlive;
    }
}
class Main {
    static int answer = Integer.MIN_VALUE;
    static int[] dirX = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dirY = {0, -1, -1, -1, 0, 1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Fish[] fish = new Fish[17];
        int[][] sea = new int[4][4];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;

                fish[num] = new Fish(num, i, j, dir, true);
                sea[i][j] = num;
            }
        }

        DFS(0, 0, 0, 0, fish, sea);
        System.out.println(answer);

    }

    public static void DFS(int x, int y, int dir, int sum, Fish[] fishes, int[][] sea) {
        // 상어 식사 : 선위치 변경 후 식사
        sum += sea[x][y];
        dir = fishes[sea[x][y]].dir;
        fishes[sea[x][y]].isAlive = false; // 물고기 죽음

        answer = Math.max(sum, answer);

        // 물고기 이동
        for (int i = 1; i <= 16; i++) {
            if (fishes[i].isAlive) {
                moveFish(x, y, fishes[i], fishes, sea);
            }
        }
        /*
            상어 이동 : 최대 3칸 갈 수 있음
            fish, sea 복사
         */
        for (int i = 1; i <= 3; i++) {
            int nx = x + dirX[dir]*i;
            int ny = y + dirY[dir]*i;

            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
                // 경계 벗어날 경우
                continue;
            }
            if (!fishes[sea[nx][ny]].isAlive) {
                // 물고기가 없는 경우
                continue;
            }

            // 복제
            Fish[] tempFish = new Fish[17];
            for (int j = 1; j <= 16; j++) {
                Fish fish = fishes[j];
                tempFish[j] = new Fish(fish.idx, fish.x, fish.y, fish.dir, fish.isAlive);
            }
            int[][] tempSea = new int[4][4];
            for (int k = 0; k < 4; k++) {
                tempSea[k] = sea[k].clone();
            }

            // 상어 이동
            DFS(nx, ny, dir, sum, fishes, sea);

            // 상어 백트래킹
            fishes = tempFish;
            sea = tempSea;

        }

    }

    public static void moveFish(int x, int y, Fish fish, Fish[] fishes, int[][] sea) {

        for (int i = 0; i < 8; i++) {
            int nx = fish.x + dirX[fish.dir];
            int ny = fish.y + dirY[fish.dir];

            // 경계를 넘거나 상어가 있는 경우
            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || (nx == x && ny == y)) {
                // 최대 8번 회전할 수 있도록 한다.
                fish.dir = (fish.dir + 1) % 8;
                continue;
            }

            // 위치 변경
            Fish temp = fishes[sea[nx][ny]];

            sea[fish.x][fish.y] = temp.idx;
            sea[nx][ny] = fish.idx;
            temp.x = fish.x;
            temp.y = fish.y;
            fish.x = nx;
            fish.y = ny;
            break;
        }

    }
}
