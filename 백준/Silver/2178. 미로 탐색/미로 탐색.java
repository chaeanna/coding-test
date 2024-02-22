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
    static int n, m;
    static int[][] graph, dis;
    static int[] disX = {1, -1, 0, 0};
    static int[] disY = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][m+1];
        dis = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                graph[i][j] = str.charAt(j-1) - '0';
            }
        }
        graph[1][1] = 0;
        dis[1][1] = 1;
        BFS(1, 1); //BFS(int y, int x)
        System.out.println(dis[n][m]);
    }

    public static void BFS(int y, int x) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(y, x));

        while (!q.isEmpty()) {
            int len = q.size();
            Point p = q.poll();
            for (int l = 0; l < len; l++) {
                for (int i = 0; i < 4; i++) {
                    int dx = p.x + disX[i];
                    int dy = p.y + disY[i];

                    if (dx >= 1 && dx <= m && dy >= 1 && dy <= n
                            && graph[dy][dx] == 1) {
                        graph[dy][dx] = 0;
                        q.offer(new Point(dy, dx));
                        dis[dy][dx] = dis[p.y][p.x] + 1;
                    }
                }
            }
        }


    }
}