import java.io.*;
import java.util.*;

class Main {
    static int n, answer = Integer.MIN_VALUE;
    static int[][] player;
    static int[] order;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        player = new int[n][9];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                int score = Integer.parseInt(st.nextToken());
                player[i][j] = score;
            }
        }

        order = new int[9];
        order[3] = 0;
        visited = new boolean[9];
        visited[0] = true;
        DFS(0);
        System.out.println(answer);
    }

    public static void DFS(int level) {
        if (level == 3) {
            DFS(level+1);
            return;
        }
            // 순서 조합되면 경기 시작
        if (level >= 9) {
            answer = Math.max(game(), answer);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[level] = i;
                DFS(level+1);
                visited[i] = false;
            }
        }
    }

    public static int game() {
        int cnt = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int out = 0;
            boolean[] ru = new boolean[3];
            while (out != 3) {
                /*
                    안타: 1 -> 타자, 주자 한 루씩 진루
                    2루타: 2 -> 타자, 주자 두 루씩 진루
                    3루타: 3 -> 타자, 주자 세 루씩 진루
                    홈런: 4 -> 모든 주자와 타자 점수 포함
                    아웃: 0 -> out++
                 */
                int play = order[end];
                end = (end+1) % 9;
                int score = player[i][play];
                if (score == 0) {
                    // 아웃일 경우
                    out++;
                    continue;
                } else if (score == 4) {
                    // 홈런일 경우
                    for (int r = 0; r < 3; r++) {
                        if (ru[r]) {
                            cnt++;
                            ru[r] = false;
                        }
                    }
                    cnt++;
                    continue;
                }
                for (int r = 2; r >= 0; r--) {
                    // 루에 있는 주자들 이동
                    if (ru[r]) {
                        ru[r] = false;
                        int next = r + score;
                        if (next > 2) {
                            cnt++;
                        } else {
                            ru[next] = true;
                        }
                    }
                }
                //타자 이동
                ru[score-1] = true;
            }
        }
        return cnt;
    }
}