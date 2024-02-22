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
    static int[][] graph;
    static Queue<Point> q = new LinkedList<>();
    static int[] disX = {1, -1, 0, 0, -1, 1, -1, 1};
    static int[] disY = {0, 0, 1, -1, -1, -1, 1, 1};
    static int w, h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }

            graph = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    int n = Integer.parseInt(st.nextToken());
                    graph[i][j] = n;
                }
            }

            int answer = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (graph[i][j] == 1) {
                        graph[i][j] = 0;
                        BFS(i, j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }
    public static void BFS(int y, int x) {
        q.offer(new Point(y, x));

        while (!q.isEmpty()) {
            int len = q.size();
            Point p = q.poll();
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < disX.length; j++) {
                    int dx = p.x + disX[j];
                    int dy = p.y + disY[j];

                    if (dx >= 0 && dx < w
                            && dy >= 0 && dy < h
                            && graph[dy][dx] == 1) {
                        graph[dy][dx] = 0;
                        q.offer(new Point(dy, dx));
                    }
                }
            }
        }
    }
}