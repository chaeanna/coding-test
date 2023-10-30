import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String str = st.nextToken();
        int n = Integer.parseInt(st.nextToken());
        int result = 0;

        for (int i = 0 ; i < str.length(); i++) {
            char c = str.charAt(i);
            int check = c - 'A';
            if (check < 0) {
                check = c - '0';
            } else {
                check += 10;
            }
            result += (check * Math.pow(n, str.length() - (i+1)));
        }

        System.out.println(result);
    }
}
