import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int n, friends;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        BFS(1); // BFS(int hakbun);
        System.out.println(friends);
    }

    public static void BFS(int h) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n+1];
        for (int i : graph.get(h)) {
            visited[i] = true;
            q.offer(i);
            friends++;
        }

        int len = q.size();
        for (int i = 0; i < len; i++) {
            int f = q.poll();
            for (int j : graph.get(f)) {
                if (!visited[j] && j != 1) {
                    visited[j] = true;
                    friends++;
                }
            }
        }


    }
}