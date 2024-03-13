import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int y, x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
class Main {
    static int n, m;
    static List<ArrayList<Integer>> graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 무방향 그래프
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[n+1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                BFS(i);
                count++;
            }
        }

        System.out.println(count);

    }

    public static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            int n = q.poll();
            for (Integer i : graph.get(n)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }


    }
}