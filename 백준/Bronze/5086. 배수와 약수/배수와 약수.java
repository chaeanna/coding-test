import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        while(true) {
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if (n1 == n2 && n1 == 0) break;
            if (n1 <= n2) {
                if (n2 % n1 == 0) {
                    sb.append("factor").append("\n");
                } else {
                    sb.append("neither").append("\n");
                }
            }
            else if (n1 > n2) {
                if (n1 % n2 == 0) {
                    sb.append("multiple").append("\n");
                } else {
                    sb.append("neither").append("\n");
                }
            }
            st = new StringTokenizer(br.readLine(), " ");
        }

        System.out.println(sb);
    }
}
