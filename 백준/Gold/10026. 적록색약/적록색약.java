import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int n, normalCnt, cnt;
    static char[][] graph;
    static int[] disX = {1, -1, 0, 0};
    static int[] disY = {0, 0, 1, -1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    DFS(i, j);
                    normalCnt++;
                }
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 'G') {
                    graph[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    DFS(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(normalCnt + " " + cnt);



    }

    public static void DFS(int y, int x) {
        char color = graph[y][x];
        for (int i = 0; i < 4; i++) {
            int dx = x + disX[i];
            int dy = y + disY[i];

            if (dx >= 0 && dx < n && dy >= 0 && dy < n
                    && graph[dy][dx] == color && !visited[dy][dx]) {
                visited[dy][dx] = true;
                DFS(dy, dx);
            }


        }
    }
}