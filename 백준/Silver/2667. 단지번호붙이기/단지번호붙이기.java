import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    static int[][] graph;
    static int answer, n;
    static boolean[][] visited;
    static int[] disX = {1, -1, 0, 0};
    static int[] disY = {0, 0, 1, -1};
    static ArrayList<Integer> resultList = new ArrayList<>(); // 결과를 담을 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j); //BFS(int y, int x);
                    answer++;
                }
            }
        }

        System.out.println(answer);
        Collections.sort(resultList); // 결과 리스트를 오름차순으로 정렬
        for (int count : resultList) { // 각 단지 내의 집의 수를 출력
            System.out.println(count);
        }
    }

    public static void BFS(int y, int x) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        int count = 0;

        visited[y][x] = true;
        qx.offer(x);
        qy.offer(y);

        while (!qx.isEmpty()) {
            int len = qx.size();
            for (int i = 0; i < len; i++) {
                int dy = qy.poll();
                int dx = qx.poll();
                for (int d = 0; d < 4; d++) {
                    if (dy + disY[d] >= 0 && dy + disY[d] < n
                            && dx + disX[d] >= 0 && dx + disX[d] < n
                            && graph[dy + disY[d]][dx + disX[d]] == 1
                            && !visited[dy + disY[d]][dx + disX[d]]) {
                        visited[dy + disY[d]][dx + disX[d]] = true;
                        qx.offer(dx + disX[d]);
                        qy.offer(dy + disY[d]);
                        count++;
                    }
                }
            }
        }

        resultList.add(count+1); // 각 단지 내의 집의 수를 결과 리스트에 추가
    }
}
