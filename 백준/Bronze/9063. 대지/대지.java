import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int x_max = x[0];
        int x_min = x[0];
        int y_max = y[0];
        int y_min = y[0];
        for (int i = 1; i < n; i++) {
            x_min = Math.min(x_min, x[i]);
            x_max = Math.max(x_max, x[i]);
            y_min = Math.min(y_min, y[i]);
            y_max = Math.max(y_max, y[i]);
        }

        System.out.println((x_max - x_min) * (y_max - y_min));
    }
}
