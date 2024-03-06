import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] day;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            day = new int[n];
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                day[j] = a;
            }


            // 역방향 탐색하며 MAX 값 찾기
            int max = Integer.MIN_VALUE;
            long result = 0L;
            for (int j = n-1; j >= 0; j--) {
                if (max < day[j]) {
                    max = day[j];
                } else {
                    // max값으로 판매해야함.
                    result += (max - day[j]);
                }
            }


            System.out.println(result);

        }
    }
}