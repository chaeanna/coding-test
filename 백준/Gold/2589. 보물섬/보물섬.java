import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int y, x;
    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
class Main {
    static int n, m, answer = 0;
    static char[][] graph;
    static int[] disX = {1, -1, 0, 0};
    static int[] disY = {0, 0, 1, -1};
    static int[][] dis;
    static Queue<Point> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 'L') {
                    BFS(i, j);
                }
            }
        }

        System.out.println(answer-1);

    }

    public static void BFS(int y, int x) {
        q = new LinkedList<>();
        dis = new int[n][m];
        dis[y][x] = 1;
        q.offer(new Point(y, x));


        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int j = 0; j < 4; j++) {
                int dx = p.x + disX[j];
                int dy = p.y + disY[j];

                if (dx >= 0 && dx < m && dy >= 0 && dy < n
                        && graph[dy][dx] == 'L' && dis[dy][dx] == 0) {
                    q.offer(new Point(dy, dx));
                    dis[dy][dx] = dis[p.y][p.x] + 1;
                    answer = Math.max(answer, dis[dy][dx]);
                }
            }
        }
    }
}