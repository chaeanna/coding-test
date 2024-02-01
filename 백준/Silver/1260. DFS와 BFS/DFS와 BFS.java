import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[][] node;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        node = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            node[n1][n2] = node[n2][n1] = 1;
        }

        visited = new boolean[N+1];
        DFS(V);

        System.out.println();

        visited = new boolean[N+1];
        BFS(V);
    }

    public static void DFS(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        if (v == node.length) return;

        for (int i = 1; i < node.length; i++) {
            if (node[v][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int v) {
        queue.offer(v);
        visited[v] = true;

        System.out.print(v + " ");

        while (!queue.isEmpty()) {
            int num = queue.poll();

            for (int i = 1; i < node.length; i++) {

                if (node[num][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    System.out.print(i + " ");
                    queue.offer(i);
                }
            }
        }

    }
}
