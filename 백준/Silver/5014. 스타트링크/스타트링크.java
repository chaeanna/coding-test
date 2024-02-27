import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int F, S, G, U, D, count = 0;
    static String answer = "use the stairs";
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        BFS();
        System.out.println(answer);
    }

    public static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        visited = new boolean[F+1];
        visited[S] = true;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int location = q.poll();
                int up = location + U;
                int down = location - D;
                if (location == G) {
                    answer = String.valueOf(count);
                    break;
                }
                //업
                if (up <= F && !visited[up]) {
                    visited[up] = true;
                    q.offer(up);
                }
                //다운
                if (down >= 1 && !visited[down]) {
                    visited[down] = true;
                    q.offer(down);
                }
            }
            count++;
        }
    }
}