import java.io.*;
import java.util.*;

class Fish implements Comparable<Fish> {
    int x, y, dis;
    public Fish(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
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

        fish = new ArrayList<>();
        sea = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 9) {
                    // 상어
                    shark = new Fish(i, j, 0);
                    a = 0;
                }
                sea[i][j] = a;

            }
        }

        move();
        System.out.println(time);
    }

    public static void move() {
        int eatCnt = 0;
        int size = 2;
        boolean flag = true;
        PriorityQueue<Fish> pq = new PriorityQueue<>();
        while (flag) {
            int[][] visited = new int[n][n];
            pq.offer(new Fish(shark.x, shark.y, 0));
            flag = false;

            while (!pq.isEmpty()) {
                Fish fish = pq.poll();
                int fx = fish.x;
                int fy = fish.y;

                // 아기상어가 먹을 수 있는 물고기 인지 확인
                if (sea[fx][fy] > 0 && sea[fx][fy] < size) {
                    time += visited[fx][fy];
                    eatCnt++;
                    // 먹은 물고기 칸은 0으로 만들기
                    sea[fx][fy] = 0;

                    // 아기상어 크기와 먹은 물고기 갯수 비교
                    if (eatCnt == size) {
                        size++;
                        eatCnt = 0;
                    }

                    // 아기상어 위치 변경
                    shark.x = fx;
                    shark.y = fy;
                    pq.clear();
                    flag = true;
                    break;
                }

                // 아기상어의 이동
                for (int i = 0; i < 4; i++) {
                    int nx = fx + disX[i];
                    int ny = fy + disY[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n
                            && sea[nx][ny] <= size && visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[fx][fy] + 1;
                        pq.offer(new Fish(nx, ny, visited[nx][ny]));
                    }

                }
            }
        }
    }

}