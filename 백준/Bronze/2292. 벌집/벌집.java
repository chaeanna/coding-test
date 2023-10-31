import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[(int) Math.ceil(Math.sqrt(n))];
        num[0] = 1;
        for (int i = 1; i < num.length; i++) {
            num[i] = num[i-1] + (6 * i);
        }

        if (n == 1) {
            System.out.println(1);
        } else {
            for (int i = 1; i < num.length; i++) {
                if (n > num[i-1] && n <= num[i]) {
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }
}
