import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static boolean[][] visited;
    static int[][] graph;
    static int m, n;
    static int[] disX = {1, -1, 0, 0};
    static int[] disY = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken()); // 가로
            n = Integer.parseInt(st.nextToken()); // 세로
            int k = Integer.parseInt(st.nextToken());

            // 위치
            graph = new int[n][m];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken()); // 가로
                int b = Integer.parseInt(st.nextToken()); // 세로

                graph[b][a] = 1;
            }

            visited = new boolean[n][m];
            int answer = 0;
            for (int h = 0; h < n; h++) {
                for (int w = 0; w < m; w++) {
                    if (graph[h][w] == 1 && !visited[h][w]) {
                        visited[h][w] = true;
                        DFS(h, w);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public static void DFS(int y, int x) {

        // 동서남북 체크
        for (int i = 0; i < 4; i++) {
            int N = y + disY[i];
            int M = x + disX[i];
            if (N >= 0 && N < n && M >= 0 && M < m
                    && !visited[N][M] && graph[N][M] == 1) {
                visited[N][M] = true;
                DFS(N, M);
            }
        }

    }
}