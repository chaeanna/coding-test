import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            graph = new ArrayList<>();
            for (int j = 0; j <= N; j++) {
                graph.add(new ArrayList<Integer>());
            }

            st = new StringTokenizer(br.readLine(), " ");
            int idx = 1;
            while (st.hasMoreTokens()) {
                int a = Integer.parseInt(st.nextToken());
                graph.get(idx).add(a);
                idx++;
            }

            visited = new boolean[N+1];
            int answer = 0;
            for (int v = 1; v <= N; v++) {
                if (!visited[v]) {
                    visited[v] = true;
                    BFS(v);
                    answer++;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }

    public static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        while (!q.isEmpty()) {
            int len = q.size();
            int n = q.poll();
            for (int i = 0; i < len; i++) {
                for (int m : graph.get(n)) {
                    if (!visited[m]) {
                        visited[m] = true;
                        q.offer(m);
                    }
                }
            }
        }
    }
}