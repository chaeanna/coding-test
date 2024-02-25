import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point {
    int y, x;
    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
class Main {
    static char[][] graph, graphRb;
    static int[] disX = {1, -1, 0, 0};
    static int[] disY = {0, 0, 1, -1};
    static int n, col, ncol = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new char[n][n];
        graphRb = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = str.charAt(j);
                graph[i][j] = c;
                graphRb[i][j] = c;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 'R') {
                    BFS(i, j, 'R'); //BFS(int y, int x, char color)
                } else if (graph[i][j] == 'G') {
                    BFS(i, j, 'G');
                } else if (graph[i][j] == 'B') {
                    BFS(i, j, 'B');
                    ncol++;
                }

            }
        }

        System.out.print(col + " " + ncol);

    }

    public static void BFS(int y, int x, char color) {
        Queue<Point> q = new LinkedList<>();
        graph[y][x] = 'N';
        q.offer(new Point(y, x));

        if (color != 'B' && graphRb[y][x] != 'N') {
            while (!q.isEmpty()) {
                graphRb[y][x] = 'N';
                int len = q.size();
                Point p = q.poll();
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < 4; j++) {
                        int dx = p.x + disX[j];
                        int dy = p.y + disY[j];

                        if (dx >= 0 && dx < n && dy >= 0 && dy < n
                                && graphRb[dy][dx] != 'B' && graphRb[dy][dx] != 'N') {
                            graphRb[dy][dx] = 'N';
                            q.offer(new Point(dy, dx));
                        }
                    }
                }
            }
            ncol++;
            q.offer(new Point(y, x));
        }

        while (!q.isEmpty()) {
            int len = q.size();
            Point p = q.poll();
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < 4; j++) {
                    int dx = p.x + disX[j];
                    int dy = p.y + disY[j];

                    if (dx >= 0 && dx < n && dy >= 0 && dy < n
                            && graph[dy][dx] == color) {
                        graph[dy][dx] = 'N';
                        q.offer(new Point(dy, dx));
                    }
                }
            }
        }
        col++;

    }
}