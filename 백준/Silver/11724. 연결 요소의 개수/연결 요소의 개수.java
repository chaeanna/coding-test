import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int answer = 0;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        visited = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                BFS(i);
            }
        }

        System.out.println(answer);

    }

    public static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int num = q.poll();
                for (int g : graph.get(num)) {
                    if (!visited[g]) {
                        visited[g] = true;
                        q.offer(g);
                    }
                }
            }
        }
        answer++;

    }
}