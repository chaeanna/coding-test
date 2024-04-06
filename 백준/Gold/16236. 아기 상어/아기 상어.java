import java.io.*;
import java.util.*;

class Fish implements Comparable<Fish> {
    int x, y, dis, size;
    public Fish(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Fish(int x, int y, int dis, int size) {
        this.x = x;
        this.y = y;
        this.dis = dis;
        this.size = size;
    }

    @Override
    public int compareTo(Fish o) {
        if (this.dis == o.dis) {
            //거리가 같을 경우
            if (this.x == o.x) {
                // 왼쪽에 있는 물고기
                return this.y - o.y;

            } else {
                // 가장 위에 물고기
                return this.x - o.x;
            }

        } else {
            // 최소 거리로 정렬
            return this.dis - o.dis;
        }
    }

}
class Main {
    static Fish shark;
    static List<Fish> fish;
    static int[][] sea;
    static int time = 0, n;
    static int[] disX = {1, -1, 0, 0};
    static int[] disY = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        shark = new Fish(0, 0, 0, 2);
        fish = new ArrayList<>();
        sea = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 9) {
                    // 상어
                    shark.x = i;
                    shark.y = j;
                    sea[i][j] = 0;

                } else if (a != 0) {
                    fish.add(new Fish(i, j, 0, a));
                    sea[i][j] = a;
                } else {
                    sea[i][j] = a;
                }
            }
        }

        move();
        System.out.println(time);
    }

    public static void move() {
        int eatCnt = 0;
        while (true) {
            // 먹을 물고기가 없을 경우
            if (fish.size() == 0) return;
            // 아기 상어보다 작은 물고기 위치 찾기
            List<Fish> list = new ArrayList<>();
            for (Fish f : fish) {
                int s = f.size;
                if (shark.size > s) {
                    if (sea[f.x][f.y] == 0) continue;
                    int dis = distance(f.x, f.y);
                    // 거리가 0이면 리스트에 넣지 않기
                    if (dis == 0) continue;
                    list.add(new Fish(f.x, f.y, dis, s));
                }
            }

            if (list.size() == 0) {
                // 아기 상어보다 작은 물고기가 없다면 엄마 상어 요청
                return;
            }
            // 최소 거리순으로 정렬
            Collections.sort(list);
            Fish eat = list.get(0);
            if (eat.dis == 0) {
                // 이동 불가
                return;
            }
            // 아기상어 이동
            shark.x = eat.x;
            shark.y = eat.y;
            eatCnt++;
            sea[eat.x][eat.y] = 0;
            // 아기상어 이동시간
            time += eat.dis;
            // 아기상어 크기 비교
            if (shark.size == eatCnt) {
                shark.size++;
                eatCnt = 0;
            }
        }
    }

    public static int distance(int fx, int fy) {
        Queue<Fish> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.offer(new Fish(shark.x, shark.y));
        int[][] map = new int[n][n];
        map[shark.x][shark.y] = 0;
        visited[shark.x][shark.y] = true;

        while (!q.isEmpty()) {
            Fish f = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = f.x + disX[i];
                int ny = f.y + disY[i];
                // 아기 상어 크기보다 작거나 같으면 지나갈 수 있다.
                if (nx >= 0 && nx < n && ny >= 0 && ny < n
                        && sea[nx][ny] <= shark.size && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    map[nx][ny] = map[f.x][f.y] + 1;
                    q.offer(new Fish(nx, ny));
                }
            }
        }

        return map[fx][fy];
    }
}