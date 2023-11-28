import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int x = 0;
        int y = 0;

        for (int i = -999; i <= 999; i++) {
            int n1 = a * i;
            int n2 = d * i;
            for (int j = -999; j <= 999; j++) {
                if ((n1 + (b * j)) == c && ((n2 + (e * j)) == f)) {
                    y = j;
                    break;
                }
            }
            if ((n1 + (b * y)) == c && ((n2 + (e * y)) == f)) {
                x = i;
                break;
            }
        }

        System.out.println(x + " " + y);
    }
}
