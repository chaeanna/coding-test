import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int x_w = w - x;
        int y_h = h - y;
        int x_0 = x - 0;
        int y_0 = y - 0;

        int min1 = Math.min(x_w, x_0);
        int min2 = Math.min(y_h, y_0);

        System.out.println(Math.min(min1, min2));
    }
}
