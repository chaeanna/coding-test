import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 1;
        int prev = 0;

        while (true) {
            if (n <= count + prev) {
                if (count % 2 == 1) {
                    System.out.println((count - (n - prev - 1)) + "/" + (n - prev));
                } else {
                    System.out.println((n - prev) + "/" + (count - (n - prev - 1)));
                }
                break;
            } else {
                prev += count;
                count++;
            }
        }
    }
}
