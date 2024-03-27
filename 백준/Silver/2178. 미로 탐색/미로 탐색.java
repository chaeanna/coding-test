import java.io.*;
import java.util.*;

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    static int n, m;
    static int[][] graph, answer;
    static boolean[][] visited;
    static int[] disX = {1, -1, 0, 0};
    static int[] disY = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        answer = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        visited = new boolean[n][m];
        visited[0][0] = true;
        BFS(0, 0);
        System.out.println(answer[n-1][m-1]);
    }
    public static void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        answer[x][y] = 1;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + disX[i];
                int ny = p.y + disY[i];
                if (nx < n && nx >= 0 && ny < m && ny >= 0
                        && graph[nx][ny] == 1 && !visited[nx][ny]) {
                    answer[nx][ny] = answer[p.x][p.y] + 1;
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }
        }

    }
}