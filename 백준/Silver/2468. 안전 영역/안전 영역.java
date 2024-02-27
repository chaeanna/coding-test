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
    static int n, count, answer = Integer.MIN_VALUE, level = -1;
    static int[][] graph;
    static boolean[][] visited;
    static int[] disX = {1, -1, 0, 0};
    static int[] disY = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        int  max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(graph[i][j], max);
            }
        }

        while (true) {
            count = 0;

            level++;
            if (level == max) {
                break;
            }
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && graph[i][j] > level) {
                        visited[i][j] = true;
                        BFS(i, j);
                        count++;
                    }
                }
            }

            answer = Math.max(answer, count);
        }
        System.out.println(answer);

    }

    public static void BFS(int y, int x) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(y, x));

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int dx = p.x + disX[j];
                    int dy = p.y + disY[j];

                    if (dx >= 0 && dx < n && dy >= 0 && dy < n
                            && graph[dy][dx] > level && !visited[dy][dx]) {
                        visited[dy][dx] = true;
                        q.offer(new Point(dy, dx));
                    }
                }
            }
        }

    }
}