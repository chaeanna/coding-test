import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");
            graph = new ArrayList<>();
            graph.add(new ArrayList<Integer>());
            for (int n = 1; n <= N; n++) {
                graph.add(new ArrayList<Integer>());
                int a = Integer.parseInt(st.nextToken());
                graph.get(n).add(a);
            }

            visited = new boolean[N+1];
            int answer = 0;
            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    DFS(j);
                    answer++;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public static void DFS(int v) {
        for (int i : graph.get(v)) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(i);
            }
        }
    }
}