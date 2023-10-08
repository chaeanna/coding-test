import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int[] input = new int[k];
        int index = -1;
        int result = 0;

        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                input[index] = 0;
                index--;
            } else {
                index++;
                input[index] = n;
            }
        }

        for (int j = 0; j <= index; j++) {
            result += input[j];
        }
        System.out.println(result);
    }
}
