import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Main {
    static int n, l, r, count;
    static int[][] graph;
    static boolean[][] visited;
    static List<Point> list = new ArrayList<>();
    static int[] disX = {1, -1, 0, 0};
    static int[] disY = {0, 0, 1, -1};
    static boolean move = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move();

        System.out.println(count);
    }

    public static void move() {
        while (true) {
            visited = new boolean[n][n];
            move = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        BFS(i, j);
                    }
                }
            }
            if (!move) {
                break;
            } else {
                count++;
            }

        }
    }

    public static void BFS(int y, int x) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(y, x));
        visited[y][x] = true;
        list.add(new Point(y, x));

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int j = 0; j < 4; j++) {
                int dx = p.x + disX[j];
                int dy = p.y + disY[j];

                if (dx >= 0 && dx < n && dy >= 0 && dy < n) {
                    int check = Math.abs(graph[p.y][p.x] - graph[dy][dx]);
                    if (!visited[dy][dx] && check >= l && check <= r) {
                        visited[dy][dx] = true;
                        move = true;
                        list.add(new Point(dy, dx));
                        q.offer(new Point(dy, dx));
                    }
                }
            }
        }

        int sum = 0;
        for (Point p : list) {
            sum += graph[p.y][p.x];
        }
        for (Point p : list) {
            graph[p.y][p.x] = sum / list.size();
        }
        list.removeAll(list);
    }
}
