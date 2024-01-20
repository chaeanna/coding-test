import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] answer;
    static int[] fibo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int f = Integer.parseInt(br.readLine());
            answer = new int[f+1][2];
            fibo = new int[f+1];
            if (f == 0) {
                fibo[0] = 0;
                answer[0][0]++;
            } else if (f == 1) {
                fibo[1] = 1;
                answer[1][1]++;
            } else {
                fibonacci(f);
            }

            System.out.println(answer[f][0] + " " + answer[f][1]);
        }


    }

    public static void fibonacci(int n) {
        fibo[0] = 0;
        answer[0][0]++;
        fibo[1] = 1;
        answer[1][1]++;

        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i-2] + fibo[i-1];
            answer[i][0] = answer[i-2][0] + answer[i-1][0];
            answer[i][1] = answer[i-2][1] + answer[i-1][1];
        }
    }
}
