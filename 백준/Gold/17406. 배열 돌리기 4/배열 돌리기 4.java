import java.io.*;
import java.util.*;

class Operation {
    int r, c, s;

    public Operation(int r, int c, int s) {
        this.r = r;
        this.c = c;
        this.s = s;
    }
}

class Main {
    static int n, m, k, answer = Integer.MAX_VALUE;
    static int[] order;
    static boolean[] visited;
    static int[][] map;
    static Operation[] op;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        op = new Operation[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            op[i] = new Operation(r, c, s);
        }

        visited = new boolean[k];
        order = new int[k];
        DFS(0);
        System.out.println(answer);

    }

    public static void DFS(int level) {
        if (level == k) {
            // 복사
            int[][] temp = new int[n][m];
            for (int i = 0; i < n; i++) {
                temp[i] = map[i].clone();
            }
            calcMin(temp);
            return;
        }

        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[level] = i;
                DFS(level+1);
                visited[i] = false;
            }
        }
    }

    public static void calcMin(int[][] temp) {
        // 회전
        for (int i = 0; i < order.length; i++) {
            int num = order[i];
            int lx = (op[num].r - op[num].s) - 1;
            int ly = (op[num].c - op[num].s) - 1;
            int rx = (op[num].r + op[num].s) - 1;
            int ry = (op[num].c + op[num].s) - 1;
            rotation(lx, ly, rx, ry, temp); // (lx, ly) ~ (rx, ry)
        }

        // 최솟값 구하기
        calc(temp);

    }

    public static void calc(int[][] temp) {
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += temp[i][j];
            }
            answer = Math.min(answer, sum);
        }
    }

    public static void rotation(int lx, int ly, int rx, int ry, int[][] temp) {
        // 한 칸만 남을 경우
        if (lx == rx && ly == ry) {
            return;
        }

        // 버려지는 부분 저장
        int[] save = new int[3];
        save[0] = temp[lx][ry];
        save[1] = temp[rx][ry];
        save[2] = temp[rx][ly];

        // 오른쪽으로 이동
        for (int i = ry; i > ly; i--) {
            temp[lx][i] = temp[lx][i-1];
        }

        // 아래쪽으로 이동
        for (int i = rx; i > lx; i--) {
            if (i == lx + 1) {
                // 버려진 부분 넣기
                temp[i][ry] = save[0];
            } else {
                temp[i][ry] = temp[i-1][ry];
            }
        }

        // 왼쪽으로 이동
        for (int i = ly; i < ry; i++) {
            if (i == ry - 1) {
                // 버려진 부분 넣기
                temp[rx][i] = save[1];
            } else {
                temp[rx][i] = temp[rx][i+1];
            }

        }

        // 위쪽으로 이동
        for (int i = lx; i < rx; i++) {
            if (i == rx - 1) {
                // 버려진 부분 넣기
                temp[i][ly] = save[2];
            } else {
                temp[i][ly] = temp[i+1][ly];
            }

        }

        // 좁혀가기
        rotation(lx+1, ly+1, rx-1, ry-1, temp);
    }


}