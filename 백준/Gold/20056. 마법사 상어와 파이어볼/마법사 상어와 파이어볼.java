import java.io.*;
import java.util.*;

class FireBall {
    int x, y, m, s, d;
    public FireBall(int x, int y, int m, int s, int d){
        this.x = x;
        this.y = y;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}

class Main {
    static int N, M, K;
    static List<FireBall> fireBall;
    static ArrayList<FireBall>[][] map;
    static int[] disX = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] disY = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //격자칸
        M = Integer.parseInt(st.nextToken()); //초기 파이어볼 개수
        K = Integer.parseInt(st.nextToken()); //이동횟수

        fireBall = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            fireBall.add(new FireBall(x, y, m, s, d));
        }

        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                map[i][j] = new ArrayList<>();
        }


        for (int i = 0; i < K; i++) {
            move();
            moveSplit();
        }

        int sum = 0;
        for (FireBall fb : fireBall) {
            sum += fb.m;
        }
        System.out.println(sum);
    }

    public static void move() {
        // fireball 하나씩 이동
        for (FireBall fb : fireBall) {
            // 이동 위치 확인
            int cur_x = (fb.x + N + disX[fb.d] * (fb.s%N)) % N;
            int cur_y = (fb.y + N + disY[fb.d] * (fb.s%N)) % N;

            fb.x = cur_x;
            fb.y = cur_y;

            map[fb.x][fb.y].add(fb);
        }

    }

    public static void moveSplit() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j].size() < 2){
                    map[i][j].clear();
                    continue;
                }

                int newM = 0;
                int newS = 0;
                int size = map[i][j].size();
                int oddCnt = 0;
                int evenCnt = 0;
                for (FireBall fb : map[i][j]) {
                    newM += fb.m;
                    newS += fb.s;
                    if (fb.d % 2 == 0) {
                        evenCnt++;
                    } else {
                        oddCnt++;
                    }
                    fireBall.remove(fb);
                }
                map[i][j].clear();

                newM /= 5;
                if (newM == 0) continue;
                newS /= size;

                if (evenCnt == size || oddCnt == size) {
                    // 모두 짝수거나 홀수
                    for (int a = 0; a <= 6; a += 2) {
                        fireBall.add(new FireBall(i, j, newM, newS, a));
                    }
                } else {
                    for (int a = 1; a <= 7; a += 2) {
                        fireBall.add(new FireBall(i, j, newM, newS, a));
                    }
                }

            }
        }

    }
}