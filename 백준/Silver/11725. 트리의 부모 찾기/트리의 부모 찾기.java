import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N+1];
        parents = new int[N+1];
        DFS(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    public static void DFS(int v) {
        if (v != 1 && graph.get(v).size() == 1) {
            int n = graph.get(v).get(0);
            parents[v] = n;
        } else {
            visited[v] = true;
            for (int i : graph.get(v)) {
                if (!visited[i]) {
                    visited[i] = true;
                    DFS(i);
                    visited[i] = false;
                }
            }
            if (v == 1) return;
            for (int i : graph.get(v)) {
                if (visited[i]) {
                    parents[v] = i;
                    visited[v] = false;
                    return;
                }
            }
        }

    }
}