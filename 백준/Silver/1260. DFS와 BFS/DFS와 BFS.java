import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, m, v;
    static int[][] graph;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visited = new boolean[n+1];
        DFS(v);
        System.out.println(sb);
        sb.setLength(0); //초기화
        BFS(v);
        System.out.println(sb);
    }

    public static void DFS(int v) {
        sb.append(v).append(" ");
        visited[v] = true;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && graph[v][i] == 1) {
                visited[i] = true;
                DFS(i);
            }
        }

    }

    public static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n+1];
        visited[v] = true;
        q.offer(v);
        sb.append(v).append(" ");

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && graph[node][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
                    sb.append(i).append(" ");
                }
            }
        }
    }
}