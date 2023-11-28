import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[][] paint;
    public static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        paint = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'W') {
                    paint[i][j] = true;
                }
            }
        }

        int n_row = n - 7;
        int m_col = m - 7;

        for(int i = 0; i < n_row; i++) {
            for (int j = 0; j < m_col; j++) {
                chess(i, j);
            }
        }

        System.out.println(min);


    }

    public static void chess(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        // 시작 칸의 색깔
        boolean WB = paint[x][y];

        for(int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                if (paint[i][j] != WB) {
                    count++;
                }
                // 다음 색은 달라야함.
                WB = (!WB);
            }

            // 다음 칸 색은 달라야함.
            WB = !WB;
        }

        // 첫 번째 칸의 색과 첫 번째 칸의 색과 반대되는 색일 때를 나누어
        // 최솟값을 count에 저장
        count = Math.min(count, 64-count);

        // count와 min을 비교해서 최솟값을 min에 계속 저장
        min = Math.min(count, min);
    }
}
