import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int n3 = Integer.parseInt(st.nextToken());
        int count = 0;
        int n = 0;

        if (n1 == n2) {
            count++;
            n = n1;
        } else if (n1 == n3) {
            count++;
            n = n1;
        }
        if (n2 == n3) {
            count++;
            n = n2;
        }

        switch(count) {
            case 0:
                int result = Math.max(Math.max(n1, n2),n3) * 100;
                System.out.println(result);
                break;
            case 1:
                result = 1000 + (n * 100);
                System.out.println(result);
                break;
            case 2:
                result = 10000 + (n * 1000);
                System.out.println(result);
                break;
            default:
                break;
        }

    }

}
