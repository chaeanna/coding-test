import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        parents = new int[N + 1];
        DFS(1, -1); // 시작 노드는 1, 시작 노드의 부모는 없으므로 -1로 설정

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append('\n');
        }
        System.out.print(sb);
    }

    public static void DFS(int v, int parent) {
        parents[v] = parent; // 현재 노드의 부모 노드 설정

        for (int child : graph.get(v)) {
            if (child != parent) { // 부모 노드는 다시 방문하지 않도록 제외
                DFS(child, v); // 재귀 호출
            }
        }
    }
}
